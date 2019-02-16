package com.nhanhv.lazada.View.ManHinhChao;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nhanhv.lazada.R;
import com.nhanhv.lazada.View.TrangChu.TrangChuActivity;

import java.util.TimerTask;

public class ManHinhChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);
        init();
    }

    private void init() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                onFinish();
            }
        });
        thread.start();
    }
    private void onFinish() {
        Intent intentTrangChu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
        startActivity(intentTrangChu);
        finish();
    }
}
