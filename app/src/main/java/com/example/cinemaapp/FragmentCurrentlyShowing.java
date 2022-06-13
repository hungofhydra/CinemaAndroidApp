package com.example.cinemaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.Models.Test;
import com.example.cinemaapp.databinding.FragmentCurrentlyShowingBinding;

public class FragmentCurrentlyShowing extends Fragment {
    private RecyclerView recyclerView;
    private FragmentCurrentlyShowingBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_currently_showing, container, false);

        binding = FragmentCurrentlyShowingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
 
        recyclerView = root.findViewById(R.id.recyclerViewCurrentlyShowing);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Test[] tests = new Test[]{
                new Test("Avengers", "2018 film", R.drawable.ic_profile),
                new Test("Venom", "2018 film", R.drawable.ic_profile),
                new Test("Batman", "2014 film", R.drawable.ic_profile),
                new Test("Spiderman", "2012 film", R.drawable.ic_profile),
                new Test("Jumanji", "2011 film", R.drawable.ic_profile),
                new Test("Hulk", "2015 film", R.drawable.ic_profile),
                new Test("Avatar", "2012 film", R.drawable.ic_profile)
        };

        MovieAdapter movieAdapter = new MovieAdapter(tests, FragmentCurrentlyShowing.this);
        recyclerView.setAdapter(movieAdapter);


        return root;

    }
}