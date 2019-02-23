package com.nhanhv.lazada.model.trangChu;

import com.nhanhv.lazada.model.entity.LoaiSanPham;

import java.util.List;

public interface LoadLoaiSanPhamListener {
    public void onLoadLSPSuccess(List<LoaiSanPham> loaiSanPhams);
    public void onLoadLSPFailure(String msg);
}
