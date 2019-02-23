package com.nhanhv.lazada.rest;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadJSON extends AsyncTask<String, Void, String> {
    public static final String BASE_URL = "http://10.0.3.2/";
    public static final String LOAISANPHAM_URL = "http://10.0.3.2/weblazada/loaisanpham0.php?maloaicha=";
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder result = new StringBuilder();
        String link = strings[0];
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(isr);
            String line = "";
            while ((line = bReader.readLine()) != null){
                result.append(line);
            }
            bReader.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
