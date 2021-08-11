package com.example.bottomnavigationbar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigationbar.R;


public class HomeFragments extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.frament_home,container,false);
        return view;
    }
}

