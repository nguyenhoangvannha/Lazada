package com.nhanhv.lazada.View.TrangChu.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhanhv.lazada.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThoiTrangFragment extends Fragment {


    public ThoiTrangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thoi_trang, container, false);
    }

}
