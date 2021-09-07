package com.example.pelayanan;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
//import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

//import com.github.barteksc.pdfviewer.PDFView;
//import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
//import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
//import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
//import com.shockwave.pdfium.PdfDocument;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class PDFViewerFragment<STATE_CURRENT_PAGE_INDEX> extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";

    private static final String STATE_CURRENT_PAGE_INDEX = "current_page_index";
    private ParcelFileDescriptor fileDescriptor;
    private PdfRenderer pdfRenderer;
    private PdfRenderer.Page Currentpage;
    private ImageView imageView;
    private Button previous, next, show;

    private String mParam1;
    private String mParam2;

    public PDFViewerFragment() {
        // Required empty public constructor
    }

    public static PDFViewerFragment newInstance(String param1) {
        PDFViewerFragment fragment = new PDFViewerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_p_d_f_viewer, container, false);
//        pdfView = (PDFView)view.findViewById(R.id.pdf);
//        pdfView.fromAsset("a.pdf")
//                .enableSwipe(true)
//                .enableDoubletap(false)
//                .load();
        return view;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView)view.findViewById(R.id.img);
        next = (Button)view.findViewById(R.id.btnnext);
        previous = (Button)view.findViewById(R.id.btnprevious);
        show = (Button) view.findViewById(R.id.btnshow);

        show.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

        int index = 0;
        if (null != savedInstanceState){
            index = savedInstanceState.getInt(STATE_CURRENT_PAGE_INDEX,0);
        }
        showPage(index);
    }

    @Override
    public void onAttach(@NotNull Activity activity) {
        super.onAttach(activity);
        try {
            openRenderer(activity);
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(activity, "eror !" + e.getMessage(), Toast.LENGTH_SHORT).show();
            activity.finish();

        }
    }

    @Override
    public void onDetach() {
        try {
            closeRenderer();
        }catch (IOException e){
            e.printStackTrace();
        }
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != Currentpage){
            outState.putInt(STATE_CURRENT_PAGE_INDEX, Currentpage.getIndex());
        }
    }

    private void openRenderer(Context context) throws IOException {
        fileDescriptor = context.getAssets().openFd("a.pdf").getParcelFileDescriptor();
        pdfRenderer = new PdfRenderer(fileDescriptor);
    }
    private void closeRenderer() throws IOException{
        if (null != Currentpage){
            Currentpage.close();
        }
        pdfRenderer.close();
        fileDescriptor.close();
    }

    private void showPage(int index){
        if (pdfRenderer.getPageCount() <= index){
            return;
        }
        if (null != Currentpage){
            Currentpage.close();
        }
        Currentpage = pdfRenderer.openPage(index);

        Bitmap bitmap = Bitmap.createBitmap(Currentpage.getWidth(), Currentpage.getHeight(), Bitmap.Config.ARGB_8888);
        Currentpage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
        imageView.setImageBitmap(bitmap);
        updateUi();
    }

    private void updateUi() {
        int index = Currentpage.getIndex();
        int pageCount = pdfRenderer.getPageCount();
        previous.setEnabled(0 != index);
        next.setEnabled(index + 1 < pageCount);
        getActivity().setTitle(getString(R.string.app_name_with_index, index + 1, pageCount));
    }

    public int getPageCount(){
        return pdfRenderer.getPageCount();
    }

    private void displayFromAsset(String assetFileName) {
//        pdfFileName = assetFileName;
//
//        pdfView.fromAsset(assetFileName)
//                .defaultPage(pageNumber)
//                .onPageChange(this)
//                .enableAnnotationRendering(true)
//                .onLoad(this)
//                .scrollHandle(new DefaultScrollHandle(getActivity()))
//                .spacing(10) // in dp
//                .load();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnprevious: {
                showPage(Currentpage.getIndex() - 1);
                break;
            }
            case R.id.btnnext: {
                showPage(Currentpage.getIndex() + 1);
                break;
            }
            case R.id.btnshow: {
                showPage(Currentpage.getIndex());
            }
        }

    }

//    private void displayFromUri(Uri uri) {
//        pdfFileName = getFileName(uri);
//
//        pdfView.fromUri(uri)
//                .defaultPage(pageNumber)
//                .onPageChange(this)
//                .enableAnnotationRendering(true)
//                .onLoad(this)
//                .scrollHandle(new DefaultScrollHandle(getActivity()))
//                .spacing(10) // in dp
//                .load();
//    }
//    public void onResult(int resultCode, Intent intent) {
//        if (resultCode == RESULT_OK) {
//            uri = intent.getData();
//            displayFromUri(uri);
//        }
//    }


//    @Override
//    public void onPageChanged(int page, int pageCount) {
//        pageNumber = page;
//        getActivity().setTitle(String.format("%s %s / %s", "PDF Reader", page + 1, pageCount));
//    }
//
//    public String getFileName(Uri uri) {
//        String result = null;
//        if (uri.getScheme().equals("content")) {
//            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//            try {
//                if (cursor != null && cursor.moveToFirst()) {
//                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
//                }
//            } finally {
//                if (cursor != null) {
//                    cursor.close();
//                }
//            }
//        }
//        if (result == null) {
//            result = uri.getLastPathSegment();
//        }
//        return result;
//    }
//
//    private ContentResolver getContentResolver() {
//        return null;
//    }
//
//    public void loadComplete(int nbPages) {
//        PdfDocument.Meta meta = pdfView.getDocumentMeta();
//        Log.e(TAG, "title = " + meta.getTitle());
//        Log.e(TAG, "author = " + meta.getAuthor());
//        Log.e(TAG, "subject = " + meta.getSubject());
//        Log.e(TAG, "keywords = " + meta.getKeywords());
//        Log.e(TAG, "creator = " + meta.getCreator());
//        Log.e(TAG, "producer = " + meta.getProducer());
//        Log.e(TAG, "creationDate = " + meta.getCreationDate());
//        Log.e(TAG, "modDate = " + meta.getModDate());
//
//        printBookmarksTree(pdfView.getTableOfContents(), "-");
//
//    }
//
//    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
//        for (PdfDocument.Bookmark b : tree) {
//
//            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));
//
//            if (b.hasChildren()) {
//                printBookmarksTree(b.getChildren(), sep + "-");
//            }
//        }
//    }

}