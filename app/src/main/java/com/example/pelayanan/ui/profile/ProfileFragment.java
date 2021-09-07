package com.example.pelayanan.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.pelayanan.ui.profile.diri.DiriFragment;
import com.example.pelayanan.ui.profile.kantor.KantorFragment;
import com.example.pelayanan.R;
import com.example.pelayanan.databinding.ProfileFragmentBinding;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private ProfileFragmentBinding binding;
    CardView profileKantor, profileDiri;
    TextView a,b;

    TabLayout tabLayout;
    FrameLayout frameLayout;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Profile");
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = ProfileFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Fragment fragment = new KantorFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.simple, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        frameLayout = (FrameLayout)root.findViewById(R.id.simple);
        tabLayout = root.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Profile Kantor"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile Diri"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = new KantorFragment();
                switch (tab.getPosition()){
                    case 0:
                        fragment = new KantorFragment();
                        break;
                    case 1:
                        fragment = new DiriFragment();
                        break;

                }

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
;
                fragmentTransaction.replace(R.id.simple, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        menuItem.setVisible(false);

    }

}