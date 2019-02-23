package com.nhanhv.lazada.presenter.dangky;

import com.nhanhv.lazada.model.dangky.DangKyListener;
import com.nhanhv.lazada.model.dangky.DangKyModel;
import com.nhanhv.lazada.model.entity.NhanVien;
import com.nhanhv.lazada.view.dangnhap.DangKyView;

public class DangKyPresenter implements DangKyListener {
    DangKyView dangKyView;

    public DangKyPresenter(DangKyView dangKyView) {
        this.dangKyView = dangKyView;
    }

    public void thucHienDangKy(NhanVien nhanVien){
        DangKyModel dangKyModel = new DangKyModel(this);
        dangKyModel.dangKy(nhanVien);
    }

    @Override
    public void ketQuaDangKy(boolean result) {
        if (result){
            dangKyView.dangKyThanhCong();
        } else {
            dangKyView.dangKyThatBai();
        }
    }
}
