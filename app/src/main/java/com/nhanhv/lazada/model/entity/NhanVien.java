package com.nhanhv.lazada.model.entity;

public class NhanVien {
    int maNV, maLoaiNV, gioiTinh;
    String tenDangNhap, matKhau, tenNV, diaChi, ngaySinh, soDienThoai, emailDocQuyen;

    public NhanVien(String tenDangNhap, String matKhau, String tenNV, String emailDocQuyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.tenNV = tenNV;
        this.emailDocQuyen = emailDocQuyen;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaLoaiNV() {
        return maLoaiNV;
    }

    public void setMaLoaiNV(int maLoaiNV) {
        this.maLoaiNV = maLoaiNV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmailDocQuyen() {
        return emailDocQuyen;
    }

    public void setEmailDocQuyen(String emailDocQuyen) {
        this.emailDocQuyen = emailDocQuyen;
    }
}
