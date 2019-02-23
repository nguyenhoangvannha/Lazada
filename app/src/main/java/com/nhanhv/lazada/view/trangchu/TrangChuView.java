package com.nhanhv.lazada.view.trangchu;

import com.nhanhv.lazada.model.entity.LoaiSanPham;

import java.util.List;

public interface TrangChuView {
    public void showListLSP(List<LoaiSanPham> loaiSanPhams);
    public void showErrorLoadLSP(String msg);
}
