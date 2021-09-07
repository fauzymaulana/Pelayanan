package com.example.pelayanan.Model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pelayanan.R;

public class ViewHolderRecycler extends RecyclerView.ViewHolder {

    private TextView txthead;
    private TextView txtsub;


    public ViewHolderRecycler(@NonNull View itemView) {
        super(itemView);
        txthead = itemView.findViewById(R.id.texthead);
//        txtsub = itemView.findViewById(R.id.textsub);

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = getAdapterPosition();
//                String message = String.format(Locale.getDefault(),"Item Click at postion %d", position);
//                Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
//                Fragment fragment = null;
//                if (position == 0){
//                    fragment = new NoSatuFragment();
//                }
//
////                switch (position){
////                    case 0:
////                        fragment = new NoSatuFragment();
////                        break;
////
////                }
//            }
//        });
    }

    public TextView getTxthead() {
        return txthead;
    }

//    public TextView getTxtsub() {
//        return txtsub;
//    }

    public void bindView(int position) {
    }
}
