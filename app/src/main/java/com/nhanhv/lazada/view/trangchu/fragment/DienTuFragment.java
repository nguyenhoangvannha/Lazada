package com.nhanhv.lazada.view.trangchu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhanhv.lazada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DienTuFragment extends Fragment {


    public DienTuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dien_tu, container, false);
    }

}