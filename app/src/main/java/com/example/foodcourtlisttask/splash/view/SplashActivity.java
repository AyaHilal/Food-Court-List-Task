package com.example.foodcourtlisttask.splash.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.foodcourtlisttask.main.view.StoresActivity;

/**
 * Created by Aya on 26/08/2018.
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, StoresActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);
    }
}
