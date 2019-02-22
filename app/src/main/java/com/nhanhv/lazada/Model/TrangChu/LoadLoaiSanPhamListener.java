package com.nhanhv.lazada.Model.TrangChu;

import com.nhanhv.lazada.Model.entity.LoaiSanPham;

import java.util.List;

public interface LoadLoaiSanPhamListener {
    public void onLoadLSPSuccess(List<LoaiSanPham> loaiSanPhams);
    public void onLoadLSPFailure(String msg);
}
