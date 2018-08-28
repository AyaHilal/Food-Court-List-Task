package com.example.foodcourtlisttask.splash.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.foodcourtlisttask.R;
import com.example.foodcourtlisttask.main.view.StoresActivity;
import com.example.foodcourtlisttask.permissions.PermissionManagerImplementation;
import com.example.foodcourtlisttask.permissions.PermissionManagerInterface;

/**
 * Created by Aya on 26/08/2018.
 */

public class SplashActivity extends AppCompatActivity{

    PermissionManagerInterface permissionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permissionManager=new PermissionManagerImplementation(SplashActivity.this);
        boolean isConnected = permissionManager.checkConnectivity();
        if(isConnected) {
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
        else {

            Toast.makeText(SplashActivity.this, getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();

                }
            }, 3000);
        }
        }
    }

