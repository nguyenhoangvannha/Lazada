package com.nhanhv.lazada.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nhanhv.lazada.view.trangchu.fragment.DienTuFragment;
import com.nhanhv.lazada.view.trangchu.fragment.KhuyenMaiFragment;
import com.nhanhv.lazada.view.trangchu.fragment.LamDepFragment;
import com.nhanhv.lazada.view.trangchu.fragment.MeVaBeFragment;
import com.nhanhv.lazada.view.trangchu.fragment.NhaCuaDoiSongFragment;
import com.nhanhv.lazada.view.trangchu.fragment.NoiBatFragment;
import com.nhanhv.lazada.view.trangchu.fragment.TheThaoDuLichFragment;
import com.nhanhv.lazada.view.trangchu.fragment.ThoiTrangFragment;
import com.nhanhv.lazada.view.trangchu.fragment.ThuongHieuFragment;

import java.util.ArrayList;

public class TrangChuPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    public TrangChuPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new NoiBatFragment());
        fragments.add(new KhuyenMaiFragment());
        fragments.add(new DienTuFragment());
        fragments.add(new NhaCuaDoiSongFragment());
        fragments.add(new MeVaBeFragment());
        fragments.add(new LamDepFragment());
        fragments.add(new ThoiTrangFragment());
        fragments.add(new TheThaoDuLichFragment());
        fragments.add(new ThuongHieuFragment());

        titles.add("Nổi bật");
        titles.add("Khuyến mãi");
        titles.add("Điện tử");
        titles.add("Nhà cửa & đời sống");
        titles.add("Mẹ và bé");
        titles.add("Làm đẹp");
        titles.add("Thời trang");
        titles.add("Thể thao & du lịch");
        titles.add("Thương hiệu");
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
