package com.nhanhv.lazada.Presenter.trangchu;

import android.util.Log;

import com.nhanhv.lazada.Model.TrangChu.LoadLoaiSanPham;
import com.nhanhv.lazada.Model.TrangChu.LoadLoaiSanPhamListener;
import com.nhanhv.lazada.Model.entity.LoaiSanPham;
import com.nhanhv.lazada.View.TrangChu.TrangChuView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrangChuPresenter implements LoadLoaiSanPhamListener {
    private TrangChuView trangChuView;

    public TrangChuPresenter(TrangChuView trangChuView) {
        this.trangChuView = trangChuView;
    }

    public void loadListLSP(int maLoaiCha){
        LoadLoaiSanPham loadLoaiSanPham = new LoadLoaiSanPham(this);
        loadLoaiSanPham.loadListLSP(maLoaiCha);
    }

    @Override
    public void onLoadLSPSuccess(List<LoaiSanPham> loaiSanPhams) {
        trangChuView.showListLSP(loaiSanPhams);
    }

    @Override
    public void onLoadLSPFailure(String msg) {
        trangChuView.showErrorLoadLSP(msg);
    }
}
