package com.nhanhv.lazada.view.dangnhap;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.nhanhv.lazada.adapter.DangNhapPagerAdapter;
import com.nhanhv.lazada.R;

public class DangNhapActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabBar;
    ViewPager pagerDangNhap;
    DangNhapPagerAdapter dangNhapPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolBar);
        tabBar = findViewById(R.id.tabBar);
        pagerDangNhap = findViewById(R.id.pagerDangNhap);
        dangNhapPagerAdapter  = new DangNhapPagerAdapter(this, getSupportFragmentManager());

        pagerDangNhap.setAdapter(dangNhapPagerAdapter);

        setSupportActionBar(toolbar);
        tabBar.setupWithViewPager(pagerDangNhap);
    }
}
