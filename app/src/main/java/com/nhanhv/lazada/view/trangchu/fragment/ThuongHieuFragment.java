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
public class ThuongHieuFragment extends Fragment {


    public ThuongHieuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thuong_hieu, container, false);
    }

}
