package com.example.pelayanan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pelayanan.Model.ItemModel;
import com.example.pelayanan.R;

import java.util.ArrayList;
import java.util.Locale;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderRecycler> {

    private ArrayList<ItemModel> dataItem;
    private Context mcontext;
    private ItemClickListener clickListener;



//    public AdapterRecyclerView(Context context, ArrayList<ItemModel> data){
//        this.dataItem = data;  mcontext = context;
//    }

    public AdapterRecyclerView(ArrayList<ItemModel> data, ItemClickListener clickListener) { this.dataItem = data;
    this.clickListener = clickListener;
    }

//    public AdapterRecyclerView(ArrayList<ItemModel> data) {this.dataItem = data;
//    }


    @NonNull
    @Override
    public ViewHolderRecycler onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolderRecycler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRecycler holder, int position) {
//        Mengambil data dari method getHead sesuai posisi INdex pada Class ViewHolderRecycler
        ItemModel TxtHead = dataItem.get(position);
        holder.textHead.setText(TxtHead.getHead());
//        ItemModel TxtSub = dataItem.get(position);
//        holder.textSub.setText(TxtSub.getSub());

        holder.parentLayout.setOnClickListener(v -> {

//            String message = String.format(Locale.getDefault(),"Item Click at postion %d", position);
//            Toast.makeText(v.getContext(), "Ini CardView " + position, Toast.LENGTH_SHORT).show();
//            Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();

            Toast.makeText(v.getContext(), dataItem.get(position).getHead(), Toast.LENGTH_SHORT).show();
            clickListener.onItemClick(dataItem.get(position));


//            Fragment fragment = null;
//            if (dataItem.get(position).getHead().equals("Pelayanan Pendaftaram Tanah Pertama kali")){
////                fragment = NoSatuFragment.newInstance();
////                FragmentTransaction transaction =
//////                Intent intent = new Intent(SlideshowFragment, MainActivity2.class);
//////                mcontext.startActivity(intent);
//            }
        });

    }

    public interface ItemClickListener{
        public void onItemClick(ItemModel model);

    }


//    @Override
//    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
//        ((ViewHolderRecycler) holder).bindView(position);
////        TextView textHead = holder.textHead;
////        TextView textSub = holder.textSub;
//
////        textHead.setText(dataItem.get(position).getHead());
////        textSub.setText(dataItem.get(position).getSub());
////        String item1 = dataItem.get(position);
////        String item2 = dataItem.get(position);
////        holder.getTextHead().setText(item1);
////        holder.getTextSub().setText(item2);
//
//    }


//    @Override
//    public int getItemViewType(int position) {
//        return R.layout.fragment_slideshow;
//    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public void setFilter(ArrayList<ItemModel> data){
        dataItem = new ArrayList<>();
        dataItem.clear();
        dataItem.addAll(data);
        notifyDataSetChanged();
    }

    class ViewHolderRecycler extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textHead;
        TextView textSub;
        CardView parentLayout;

        public ViewHolderRecycler(View view){
            super(view);
            textHead = view.findViewById(R.id.texthead);
//            textSub = view.findViewById(R.id.textsub);
            parentLayout = view.findViewById(R.id.parentlayout);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String message = String.format(Locale.getDefault(),"Item Click at postion %d", position);
//            Toast.makeText(v.getContext(), "Ini CardView " + position, Toast.LENGTH_SHORT).show();
            Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
            Fragment fragment = null;
//            switch (position()){
//                    case 0:
//                        fragment = new NoSatuFragment();
//                        Fragment NoSatuFragment = new NoSatuFragment();
//                        FragmentManager fragmentManager = getPosition().getSupportFragmentManager();
//                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.replace(R.id.nosatu, NoSatuFragment);
//                        fragmentTransaction.addToBackStack(null);
//                        fragmentTransaction.commit();
//                        break;
//
//               }

        }
    }


}
