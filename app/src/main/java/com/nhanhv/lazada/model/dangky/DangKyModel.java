package com.nhanhv.lazada.model.dangky;

import android.util.Pair;

import com.nhanhv.lazada.model.entity.NhanVien;
import com.nhanhv.lazada.rest.DownloadJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DangKyModel {
    DangKyListener dangKyListener;

    public DangKyModel(DangKyListener dangKyListener) {
        this.dangKyListener = dangKyListener;
    }

    public void dangKy(NhanVien nhanVien){
        ArrayList<Pair<String, String>> attrs = new ArrayList<>();
        attrs.add(new Pair<String, String>("ham", "DangKyThanhVien"));
        attrs.add(new Pair<String, String>("tennv", nhanVien.getTenNV()));
        attrs.add(new Pair<String, String>("tendangnhap", nhanVien.getTenDangNhap()));
        attrs.add(new Pair<String, String>("matkhau", nhanVien.getMatKhau()));
        attrs.add(new Pair<String, String>("maloainv", nhanVien.getMaLoaiNV() + ""));
        attrs.add(new Pair<String, String>("emaildocquyen", nhanVien.getEmailDocQuyen()));
        DownloadJSON downloadJSON = new DownloadJSON(attrs, DownloadJSON.METHOD_POST);
        downloadJSON.execute(DownloadJSON.BASE_URL);
        try {
            String json = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(json);
            boolean result =  jsonObject.getBoolean("ketqua");
            dangKyListener.ketQuaDangKy(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
