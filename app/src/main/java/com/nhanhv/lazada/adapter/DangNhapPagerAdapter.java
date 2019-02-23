package com.nhanhv.lazada.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nhanhv.lazada.R;
import com.nhanhv.lazada.view.dangnhap.fragment.DangKyFragment;
import com.nhanhv.lazada.view.dangnhap.fragment.DangNhapFragment;

public class DangNhapPagerAdapter extends FragmentPagerAdapter {
    Context context;
    Fragment[] fragments = {new DangNhapFragment(), new DangKyFragment()};
    public DangNhapPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    public DangNhapPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return context.getString(R.string.title_login);
        } else {
            return context.getString(R.string.title_reg);
        }
    }
}
