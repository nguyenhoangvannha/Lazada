package com.nhanhv.lazada.View.TrangChu;

import com.nhanhv.lazada.Model.entity.LoaiSanPham;

import java.util.List;

public interface TrangChuView {
    public void showListLSP(List<LoaiSanPham> loaiSanPhams);
    public void showErrorLoadLSP(String msg);
}
