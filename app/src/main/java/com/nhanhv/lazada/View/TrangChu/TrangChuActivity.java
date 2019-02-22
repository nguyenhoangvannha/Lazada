package com.nhanhv.lazada.View.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.nhanhv.lazada.Adapter.ExpandableMenuAdapter;
import com.nhanhv.lazada.Adapter.TrangChuAdapter;
import com.nhanhv.lazada.Model.entity.LoaiSanPham;
import com.nhanhv.lazada.Presenter.trangchu.TrangChuPresenter;
import com.nhanhv.lazada.R;

import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements TrangChuView{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TabLayout tabBar;
    ViewPager pagerTrangChu;
    TrangChuAdapter trangChuAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TrangChuPresenter trangChuPresenter;
    ExpandableListView expandableMenu;
    ExpandableMenuAdapter menuAdapter;
    Button buttonSearch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        init();
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        tabBar = findViewById(R.id.tabBar);
        pagerTrangChu = findViewById(R.id.pagerTrangChu);
        expandableMenu = findViewById(R.id.expandedMenu);
        buttonSearch = findViewById(R.id.buttonSearch);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.title_open, R.string.title_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();

        trangChuAdapter = new TrangChuAdapter(getSupportFragmentManager());
        pagerTrangChu.setAdapter(trangChuAdapter);
        tabBar.setupWithViewPager(pagerTrangChu);


        trangChuPresenter = new TrangChuPresenter(this);
        trangChuPresenter.loadListLSP(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trang_chu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showListLSP(List<LoaiSanPham> loaiSanPhams) {
        Log.i("DSLOAISP", loaiSanPhams.toString());
        menuAdapter = new ExpandableMenuAdapter(this, loaiSanPhams);
        expandableMenu.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorLoadLSP(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.i("DSLOAISP", msg);
    }
}
