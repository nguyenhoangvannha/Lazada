package com.nhanhv.lazada.Model.TrangChu;

import com.nhanhv.lazada.Model.entity.LoaiSanPham;
import com.nhanhv.lazada.Rest.DownloadJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoadLoaiSanPham {
    private LoadLoaiSanPhamListener loadLoaiSanPhamListener;

    public LoadLoaiSanPham(LoadLoaiSanPhamListener loadLoaiSanPhamListener) {
        this.loadLoaiSanPhamListener = loadLoaiSanPhamListener;
    }

    public LoadLoaiSanPham() {
    }

    public List<LoaiSanPham> loadListLSP(int maLoaiCha){
        DownloadJSON downloadJSON = new DownloadJSON();
        downloadJSON.execute(DownloadJSON.LOAISANPHAM_URL + maLoaiCha);
        try {
            String jsonData = downloadJSON.get();
            List<LoaiSanPham> loaiSanPhams = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray list = jsonObject.getJSONArray("LOAISANPHAM");
            int size = list.length();
            for (int i = 0; i < size; i++){
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                JSONObject lspObj = list.getJSONObject(i);
                loaiSanPham.setmMaLoaiCha(lspObj.getInt("MALOAI_CHA"));
                loaiSanPham.setmMaLoaiSP(lspObj.getInt("MALOAISP"));
                loaiSanPham.setmTenLoaiSP(lspObj.getString("TENLOAISP"));
                loaiSanPhams.add(loaiSanPham);
            }

            loadLoaiSanPhamListener.onLoadLSPSuccess(loaiSanPhams);
            return loaiSanPhams;
        } catch (ExecutionException e) {
            e.printStackTrace();
            loadLoaiSanPhamListener.onLoadLSPFailure(e.toString());
        } catch (InterruptedException e) {
            loadLoaiSanPhamListener.onLoadLSPFailure(e.toString());
        } catch (JSONException e) {
            loadLoaiSanPhamListener.onLoadLSPFailure(e.toString());
        }
        return null;
    }
    public List<LoaiSanPham> loadListLSPCon(int maLoaiCha){
        DownloadJSON downloadJSON = new DownloadJSON();
        downloadJSON.execute(DownloadJSON.LOAISANPHAM_URL + maLoaiCha);
        List<LoaiSanPham> loaiSanPhams = new ArrayList<>();
        try {
            String jsonData = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray list = jsonObject.getJSONArray("LOAISANPHAM");
            int size = list.length();
            for (int i = 0; i < size; i++){
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                JSONObject lspObj = list.getJSONObject(i);
                loaiSanPham.setmMaLoaiCha(lspObj.getInt("MALOAI_CHA"));
                loaiSanPham.setmMaLoaiSP(lspObj.getInt("MALOAISP"));
                loaiSanPham.setmTenLoaiSP(lspObj.getString("TENLOAISP"));
                loaiSanPhams.add(loaiSanPham);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loaiSanPhams;
    }
}
