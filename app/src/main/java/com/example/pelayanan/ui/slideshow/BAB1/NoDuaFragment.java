package com.example.pelayanan.ui.slideshow.BAB1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.pelayanan.R;
import com.example.pelayanan.databinding.FragmentNoDuaBinding;

public class NoDuaFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private FragmentNoDuaBinding binding;
    FrameLayout frameLayout;
    private String mParam1;
    


    public NoDuaFragment() {
        // Required empty public constructor
    }
    public static NoDuaFragment newInstance(String head) {
        return new NoDuaFragment();
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
//        View view = inflater.inflate(R.layout.fragment_no_dua, container, false);
        binding = FragmentNoDuaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frameLayout = (FrameLayout)root.findViewById(R.id.nodua);


        return root;
    }
}