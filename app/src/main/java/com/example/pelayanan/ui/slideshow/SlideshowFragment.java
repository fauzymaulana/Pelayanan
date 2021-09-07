package com.example.pelayanan.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pelayanan.Adapter.AdapterRecyclerView;
import com.example.pelayanan.MainActivity;
import com.example.pelayanan.Model.ItemModel;
import com.example.pelayanan.ui.slideshow.BAB1.NoDelapanBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoDelapanFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoDuaBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoEmpatBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoEnamBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoLimaBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoSebelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoSembilanFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoSepuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoTigaBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoTujuhBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoTujuhFragment;
import com.example.pelayanan.R;
import com.example.pelayanan.controller.MyItem;
import com.example.pelayanan.databinding.FragmentSlideshowBinding;
import com.example.pelayanan.ui.slideshow.BAB1.NoDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB1.NoSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB2.DuaPuluhTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhDelapanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhSembilanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoDuaPuluhTujuhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhDelapanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhSembilanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoEmpatPuluhTujuhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoLimaPuluhDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoLimaPuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoLimaPuluhSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoSembilanBelasFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhDelapanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhSembilanFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB2.NoTigaPuluhTujuhFragment;
import com.example.pelayanan.ui.slideshow.BAB2.TigaPuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhDelapanFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhSembilanFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB3.NoLimaPuluhTujuhFragment;
import com.example.pelayanan.ui.slideshow.BAB4.NoEnamPuluhDuaFragment;
import com.example.pelayanan.ui.slideshow.BAB4.NoEnamPuluhFragment;
import com.example.pelayanan.ui.slideshow.BAB4.NoEnamPuluhSatuFragment;
import com.example.pelayanan.ui.slideshow.BAB4.NoEnamPuluhTigaFragment;
import com.example.pelayanan.ui.slideshow.BAB5.NoEnamPuluhEmpatFragment;
import com.example.pelayanan.ui.slideshow.BAB5.NoEnamPuluhEnamFragment;
import com.example.pelayanan.ui.slideshow.BAB5.NoEnamPuluhLimaFragment;
import com.example.pelayanan.ui.slideshow.BAB6.NoEnamPuluhTujuhFragment;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment implements AdapterRecyclerView.ItemClickListener {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    RecyclerView recyclerView;
    AdapterRecyclerView adapterRecyclerView;
    ArrayList<ItemModel> data;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("SOP Pelayanan");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

//        Dataa();
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        data = new ArrayList<>();
        for (int i = 0; i < MyItem.topSub.length; i++){
            data.add(new ItemModel(
                    MyItem.topSub[i]
            ));
        }
        adapterRecyclerView = new AdapterRecyclerView(data, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.smoothScrollToPosition(recyclerView.getBottom());
        recyclerView.setAdapter(adapterRecyclerView);

        return root;
    }

//        private void Dataa() {
//            int count = 0;
//    //        for (String nama : MyItem.topSub)
//                for (String nama : MyItem.topSub){
//                data.add(new ItemModel(MyItem.topSub[count]));
//                count++;
//    //            sampe sini
//            }
//        }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        final SearchView searchView = new SearchView(((MainActivity)getActivity()).getSupportActionBar().getThemedContext());
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menuItem.setActionView(searchView);
        searchView.setQueryHint("Telusuri...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //Data akan berubah saat user menginputkan text kunci
                newText = newText.toLowerCase();
                ArrayList<ItemModel> itemModels = new ArrayList<>();
                for (ItemModel data : data){
                    String head = data.getHead().toLowerCase();
//                    String sub = data.getSub().toLowerCase();
                    if (head.contains(newText)){
                        itemModels.add(data);
                    }
//                    else if (sub.contains(newText)){
//                        itemModels.add(data);
//                    }
                }
                adapterRecyclerView.setFilter(itemModels);
                return true;
            }
        });
        menuItem.setActionView(searchView);
//        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(ItemModel model) {
        switch (model.getHead()) {
            case "Konversi, Pengakuan dan Penegasan Hak": {
                Fragment fragment = NoSatuFragment.newInstance(model.getHead());
                Fragment NoSatuFragment = new NoSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Milik Perorangan": {
                Fragment fragment = NoDuaFragment.newInstance(model.getHead());
                Fragment NoDuaFragment = new NoDuaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Milik Badan Hukum": {
                Fragment fragment = NoTigaFragment.newInstance(model.getHead());
                Fragment NoTigaFragment = new NoTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Guna Bangunan Perorangan": {
                Fragment fragment = NoEmpatFragment.newInstance(model.getHead());
                Fragment NoEmpatFragment = new NoEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Guna Bangunan Badan Hukum": {
                Fragment fragment = NoLimaFragment.newInstance(model.getHead());
                Fragment NoLimaFragment = new NoLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Perorangan WNI": {
                Fragment fragment = NoEnamFragment.newInstance(model.getHead());
                Fragment NoEnamFragment = new NoEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Perorangan WNA": {
                Fragment fragment = NoTujuhFragment.newInstance(model.getHead());
                Fragment NoTujuhFragment = new NoTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Badan Hukum Indonesia": {
                Fragment fragment = NoDelapanFragment.newInstance(model.getHead());
                Fragment NoDelapanFragment = new NoDelapanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDelapanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Badan Hukum Asing": {
                Fragment fragment = NoSembilanFragment.newInstance(model.getHead());
                Fragment NoSembilanFragment = new NoSembilanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoSembilanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Instansi Pemerintah": {
                Fragment fragment = NoSepuluhFragment.newInstance(model.getHead());
                Fragment NoSepuluhFragment = new NoSepuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoSepuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pakai Pemerintah Asing": {
                Fragment fragment = NoSebelasFragment.newInstance(model.getHead());
                Fragment NoSebelasFragment = new NoSebelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoSebelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Pengelolaan Instansi Pemerintah/Pemda/BUMN/BUMD": {
                Fragment fragment = NoDuaBelasFragment.newInstance(model.getHead());
                Fragment NoDuaBelasFragment = new NoDuaBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Wakaf Dari Tanah Belum Bersertifikat": {
                Fragment fragment = NoTigaBelasFragment.newInstance(model.getHead());
                Fragment NoTigaBelasFragment = new NoTigaBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Wakaf Dari Tanah Negara (Pemberian Hak Tanah Pribadi)": {
                Fragment fragment = NoEmpatBelasFragment.newInstance(model.getHead());
                Fragment NoEmpatBelasFragment = new NoEmpatBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "P3MB/Prk.5": {
                Fragment fragment = NoLimaBelasFragment.newInstance(model.getHead());
                Fragment NoLimaBelasFragment = new NoLimaBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pendaftaran Hak Milik Atas Satuan Rumah Susun": {
                Fragment fragment = NoEnamBelasFragment.newInstance(model.getHead());
                Fragment NoEnamBelasFragment = new NoEnamBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Guna Usaha Perorangan": {
                Fragment fragment = NoTujuhBelasFragment.newInstance(model.getHead());
                Fragment NoTujuhBelasFragment = new NoTujuhBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTujuhBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Guna Usaha Badan Hukum": {
                Fragment fragment = NoDelapanBelasFragment.newInstance(model.getHead());
                Fragment NoDelapanBelasFragment = new NoDelapanBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDelapanBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Jual-Beli Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoSembilanBelasFragment.newInstance(model.getHead());
                Fragment NoSembilanBelasFragment = new NoSembilanBelasFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoSembilanBelasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Pewarisan/Wasiat Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhFragment = new NoDuaPuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Tukar/Menukar Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhSatuFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhSatuFragment = new NoDuaPuluhSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Hibah Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhDuaFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhDuaFragment = new NoDuaPuluhDuaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhDuaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Pembagian Hak Bersama Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = DuaPuluhTigaFragment.newInstance(model.getHead());
                Fragment DuaPuluhTigaFragment = new DuaPuluhTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, DuaPuluhTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Lelang Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhEmpatFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhEmpatFragment = new NoDuaPuluhEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Pemasukan Ke Dalam Perusahaan Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhLimaFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhLimaFragment = new NoDuaPuluhLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Merger Atas Hak Tanah dan Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhEnamFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhEnamFragment = new NoDuaPuluhEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Ganti Nama Sertifikat Hak Atas Tanah dan Hak Milik Rumah Susun": {
                Fragment fragment = NoDuaPuluhTujuhFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhTujuhFragment = new NoDuaPuluhTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Perpanjangan Jangka Waktu Hak Guna Usaha/Hak Guna Bangunan/Hak Pakai": {
                Fragment fragment = NoDuaPuluhDelapanFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhDelapanFragment = new NoDuaPuluhDelapanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhDelapanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Perpanjangan Hak Milik Atas Satuan Rumah Susun": {
                Fragment fragment = NoDuaPuluhSembilanFragment.newInstance(model.getHead());
                Fragment NoDuaPuluhSembilanFragment = new NoDuaPuluhSembilanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoDuaPuluhSembilanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Guna Bangunan Perorangan Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = TigaPuluhFragment.newInstance(model.getHead());
                Fragment TigaPuluhFragment = new TigaPuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, TigaPuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Guna Bangunan Badan Hukum Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhSatuFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhSatuFragment = new NoTigaPuluhSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Pakai Perorangan WNI Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhDuaFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhDuaFragment = new NoTigaPuluhDuaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhDuaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Pakai Perorangan WNA Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak PengelolaanPembaruan Hak Pakai Perorangan WNA Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhTigaFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhTigaFragment = new NoTigaPuluhTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Pakai Badan Hukum Indonesia Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhEmpatFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhEmpatFragment = new NoTigaPuluhEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Pakai Badan Hukum Asing Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhLimaFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhLimaFragment = new NoTigaPuluhLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Pakai Pemerintah Asing Atas Hak Guna Bangunan/Hak Pakai dan Pemberian Hak Guna Bangunan/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhEnamFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhEnamFragment = new NoTigaPuluhEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemberian Hak Guna Bangunann/Hak Pakai Di Atas Hak Pengelolaan": {
                Fragment fragment = NoTigaPuluhTujuhFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhTujuhFragment = new NoTigaPuluhTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Guna Usaha Perorangan": {
                Fragment fragment = NoTigaPuluhDelapanFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhDelapanFragment = new NoTigaPuluhDelapanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhDelapanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pembaruan Hak Guna Usaha Badan Hukum": {
                Fragment fragment = NoTigaPuluhSembilanFragment.newInstance(model.getHead());
                Fragment NoTigaPuluhSembilanFragment = new NoTigaPuluhSembilanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoTigaPuluhSembilanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Wakaf Dari Tanah Yang Sudah Bersertifikat": {
                Fragment fragment = NoEmpatPuluhFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhFragment = new NoEmpatPuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Perubahan Hak Atas Tanah": {
                Fragment fragment = NoEmpatPuluhSatuFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhSatuFragment = new NoEmpatPuluhSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pemecahan/Pemisahan Bidang Tanah Perorangan": {
                Fragment fragment = NoEmpatPuluhTigaFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhTigaFragment = new NoEmpatPuluhTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Penggabungan Bidang Tanah Perorangan": {
                Fragment fragment = NoEmpatPuluhEmpatFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhEmpatFragment = new NoEmpatPuluhEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Penggabungan Bidang Tanah Badan Hukum": {
                Fragment fragment = NoEmpatPuluhLimaFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhLimaFragment = new NoEmpatPuluhLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Sertifikat Pengganti Karena Blanko Lama Pada Hak Atas Tanah, Hak Milik Atas Rumah Susun, Dan Hak Tanggungan": {
                Fragment fragment = NoEmpatPuluhEnamFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhEnamFragment = new NoEmpatPuluhEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Sertifikat Pengganti Karena Hilang Pada Hak Atas Tanah, Hak Milik Atas Rumah Susun, Dan Hak Tanggungan": {
                Fragment fragment = NoEmpatPuluhTujuhFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhTujuhFragment = new NoEmpatPuluhTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Sertifikat Pengganti Karena Rusak Pada Hak Atas Tanah, Hak Milik Atas Rumah Susun, Dan Hak Tanggungan": {
                Fragment fragment = NoEmpatPuluhDelapanFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhDelapanFragment = new NoEmpatPuluhDelapanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhDelapanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pendaftaran Hak Tanggungan": {
                Fragment fragment = NoEmpatPuluhSembilanFragment.newInstance(model.getHead());
                Fragment NoEmpatPuluhSembilanFragment = new NoEmpatPuluhSembilanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEmpatPuluhSembilanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Penghapusan Hak Tanggungan/Roya": {
                Fragment fragment = NoLimaPuluhFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhFragment = new NoLimaPuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Peralihan Hak Tanggungan/Cessie": {
                Fragment fragment = NoLimaPuluhSatuFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhSatuFragment = new NoLimaPuluhSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Subrogasi (Perubahan Kreditur)": {
                Fragment fragment = NoLimaPuluhDuaFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhDuaFragment = new NoLimaPuluhDuaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhDuaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Blokir Pencatatan Dan Informasi Pertanahan": {
                Fragment fragment = NoLimaPuluhTigaFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhTigaFragment = new NoLimaPuluhTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Sita Pencatatan Dan Informasi Pertanahan": {
                Fragment fragment = NoLimaPuluhEmpatFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhEmpatFragment = new NoLimaPuluhEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengangkatan Sita Pencatatan Dan Informasi Pertanahan": {
                Fragment fragment = NoLimaPuluhLimaFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhLimaFragment = new NoLimaPuluhLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengecekan Informasi Sertifikat": {
                Fragment fragment = NoLimaPuluhEnamFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhEnamFragment = new NoLimaPuluhEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Surat Keterangan Pendaftaran Tanah": {
                Fragment fragment = NoLimaPuluhTujuhFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhTujuhFragment = new NoLimaPuluhTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Informasi Titik Dasar Teknik Informasi Pertanahan": {
                Fragment fragment = NoLimaPuluhDelapanFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhDelapanFragment = new NoLimaPuluhDelapanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhDelapanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Informasi Peta Pertanahan": {
                Fragment fragment = NoLimaPuluhSembilanFragment.newInstance(model.getHead());
                Fragment NoLimaPuluhSembilanFragment = new NoLimaPuluhSembilanFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoLimaPuluhSembilanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengukuran Bidang Tanah Untuk Keperluan Pengembalian Batas": {
                Fragment fragment = NoEnamPuluhFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhFragment = new NoEnamPuluhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengukuran Bidang Tanah Untuk Kegiatan Inventaris/Pengadaan Tanah": {
                Fragment fragment = NoEnamPuluhSatuFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhSatuFragment = new NoEnamPuluhSatuFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhSatuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengukuran Bidang Tanah Atas Permintaan Instansi Dan /Atau Masyarakat Untuk Mengetahui Luas Tanah": {
                Fragment fragment = NoEnamPuluhDuaFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhDuaFragment = new NoEnamPuluhDuaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhDuaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengukuran Bidang Tanah Dalam Rangka Pembuatan Peta Situasi Lengkap (Topografi)": {
                Fragment fragment = NoEnamPuluhTigaFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhTigaFragment = new NoEnamPuluhTigaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhTigaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Konsolidasi Tanah Swadaya": {
                Fragment fragment = NoEnamPuluhEmpatFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhEmpatFragment = new NoEnamPuluhEmpatFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhEmpatFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pertimbangan Teknis Pertanahan": {
                Fragment fragment = NoEnamPuluhLimaFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhLimaFragment = new NoEnamPuluhLimaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhLimaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pertimbangan Teknis Penatagunaan Tanah": {
                Fragment fragment = NoEnamPuluhEnamFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhEnamFragment = new NoEnamPuluhEnamFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhEnamFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case "Pengelolaan Pengaduan": {
                Fragment fragment = NoEnamPuluhTujuhFragment.newInstance(model.getHead());
                Fragment NoEnamPuluhTujuhFragment = new NoEnamPuluhTujuhFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.slide, NoEnamPuluhTujuhFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
        }
    }

}
