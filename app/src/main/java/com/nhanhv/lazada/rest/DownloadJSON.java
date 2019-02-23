package com.nhanhv.lazada.rest;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DownloadJSON extends AsyncTask<String, Void, String> {
    public static final String BASE_URL = "http://10.0.3.2/weblazada/loaisanpham.php";

    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;

    ArrayList<Pair<String, String>> attrs;
    int method;

    public DownloadJSON(ArrayList<Pair<String, String>> attrs, int method) {
        this.attrs = attrs;
        this.method = method;
    }

    @Override
    protected String doInBackground(String... strings) {
        String link = strings[0];
        String data = "";
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            switch (method){
                case METHOD_GET:
                    data = methodGet(connection);
                    break;
                case METHOD_POST:
                    data = methodPost(connection, attrs);
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    private String methodGet(HttpURLConnection urlConnection){
        InputStream is = null;
        StringBuilder result = new StringBuilder();
        try {
            is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(isr);
            String line = "";
            while ((line = bReader.readLine()) != null){
                result.append(line);
            }
            bReader.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    private String methodPost(HttpURLConnection connection,ArrayList<Pair<String, String>> pairs){
        String result = "";
        try {
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder();
            for (Pair<String, String> pair:pairs){
                builder.appendQueryParameter(pair.first, pair.second);
            }
            String query = builder.build().getEncodedQuery();

            OutputStream outputStream = connection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(query);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
            result = methodGet(connection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
