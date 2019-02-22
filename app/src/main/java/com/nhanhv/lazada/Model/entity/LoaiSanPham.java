package com.nhanhv.lazada.Model.entity;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPham {
    private int mMaLoaiSP;
    private String mTenLoaiSP;
    private int mMaLoaiCha;
    private List<LoaiSanPham> loaiSanPhams = new ArrayList<>();


    public LoaiSanPham() {
    }

    public LoaiSanPham(int mMaLoaiSP, String mTenLoaiSP, int mMaLoaiCha) {
        this.mMaLoaiSP = mMaLoaiSP;
        this.mTenLoaiSP = mTenLoaiSP;
        this.mMaLoaiCha = mMaLoaiCha;
    }

    public int getmMaLoaiSP() {
        return mMaLoaiSP;
    }

    public void setmMaLoaiSP(int mMaLoaiSP) {
        this.mMaLoaiSP = mMaLoaiSP;
    }

    public String getmTenLoaiSP() {
        return mTenLoaiSP;
    }

    public void setmTenLoaiSP(String mTenLoaiSP) {
        this.mTenLoaiSP = mTenLoaiSP;
    }

    public int getmMaLoaiCha() {
        return mMaLoaiCha;
    }

    public void setmMaLoaiCha(int mMaLoaiCha) {
        this.mMaLoaiCha = mMaLoaiCha;
    }

    public List<LoaiSanPham> getLoaiSanPhams() {
        return loaiSanPhams;
    }

    public void setLoaiSanPhams(List<LoaiSanPham> loaiSanPhams) {
        this.loaiSanPhams = loaiSanPhams;
    }
}
