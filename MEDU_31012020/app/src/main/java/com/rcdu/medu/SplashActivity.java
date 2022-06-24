package com.rcdu.medu;


import android.Manifest;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.view.Window;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.rcdu.medu.common.Constants;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;

    private Context mContext;

    private static final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = SplashActivity.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            checkAndRequestPermissions();


        if (ContextCompat.checkSelfPermission(SplashActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
            } else {
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    checkPreferenceValue();
                }
            }, SPLASH_TIME_OUT);
        }
    }


    private boolean checkAndRequestPermissions() {


        int storagePermission = ContextCompat.checkSelfPermission(this,

                Manifest.permission.READ_EXTERNAL_STORAGE);

//        int READ_PHONE_STATE = ContextCompat.checkSelfPermission(this,
//
//                Manifest.permission.READ_PHONE_STATE);


        int storagePermission2 = ContextCompat.checkSelfPermission(this,

                Manifest.permission.WRITE_EXTERNAL_STORAGE);

//
//        int ACCESS_COARSE_LOCATION = ContextCompat.checkSelfPermission(this,
//
//                Manifest.permission.ACCESS_COARSE_LOCATION);
//
//        int ACCESS_FINE_LOCATION = ContextCompat.checkSelfPermission(this,
//
//                Manifest.permission.ACCESS_FINE_LOCATION);


//        int cameraPermission = ContextCompat.checkSelfPermission(this,
//
//                Manifest.permission.CAMERA);
        int ACCESS_NETWORK_STATE = ContextCompat.checkSelfPermission(this,

                Manifest.permission.ACCESS_NETWORK_STATE);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
//        if (READ_PHONE_STATE != PackageManager.PERMISSION_GRANTED) {
//            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
//        }
        if (storagePermission2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }


//        if (ACCESS_COARSE_LOCATION != PackageManager.PERMISSION_GRANTED) {
//            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
//        }
//        if (ACCESS_FINE_LOCATION != PackageManager.PERMISSION_GRANTED) {
//            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        }
//
//        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
//            listPermissionsNeeded.add(Manifest.permission.CAMERA);
//        }

        if (ACCESS_NETWORK_STATE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }


        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
            return false;
        }

        return true;
    }


    private void checkPreferenceValue() {

        String pref_name;
        pref_name = Constants.getPrefrence(mContext, "User_id");

        if (!(pref_name.equals(""))) {
            startActivity(new Intent(mContext, MainActivity.class));
            overridePendingTransition(R.anim.animation_enter_from_right,
                    R.anim.animation_leave_out_to_left);
            finish();
        } else {
            startActivity(new Intent(mContext, LoginActivity.class));
            overridePendingTransition(R.anim.animation_enter_from_right,
                    R.anim.animation_leave_out_to_left);
            finish();
        }
    }

}

