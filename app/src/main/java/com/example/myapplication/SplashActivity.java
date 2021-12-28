package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        new Thread(()->{
            try {
                Thread.sleep(2650);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intent = new Intent(this , EnterActivity.class);
            startActivity(intent);
            finish();
        }).start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(intent);
        finish();
    }
}