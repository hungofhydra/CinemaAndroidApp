package com.example.cinemaapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cinemaapp.ui.Fragment.FragmentCurrentlyShowing;
import com.example.cinemaapp.ui.Fragment.FragmentShowingSoon;

public class VPAdapter extends FragmentStateAdapter {


    public VPAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentCurrentlyShowing();
            case 1:
                return new FragmentShowingSoon();
            default:
                return new FragmentCurrentlyShowing();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
