package com.nhanhv.lazada.presenter.trangchu;

import com.nhanhv.lazada.model.trangChu.LoadLoaiSanPham;
import com.nhanhv.lazada.model.trangChu.LoadLoaiSanPhamListener;
import com.nhanhv.lazada.model.entity.LoaiSanPham;
import com.nhanhv.lazada.view.trangchu.TrangChuView;

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
