package com.rcdu.medu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rcdu.medu.allSyncMethod.GetSyncData;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.connectivity.ConnectionCheck;
import com.rcdu.medu.connectivity.NetworkUtils;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String[] arrayNames = new String[]{"Attendance", "TimeTable", "Exame Schedule",
            "Information", "Holidays", "About Us"};
    int[] drawableArray = new int[]{R.drawable.ic_attendance, R.drawable.ic_time_table, R.drawable.ic_exam_schedule,
            R.drawable.ic_info, R.drawable.ic_holiday, R.drawable.ic_question};
    private static ArrayList<DataSet> data;
    public static Context mCxt;
    public static DataBaseManipulate db;
    GetSyncData syncData;
    TextView username, userphone, userdob, userdesignation, useremail, lastSyncDateTime;
    ConnectionCheck connectionCheck;
    private int connectStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCxt = MainActivity.this;
        db = new DataBaseManipulate(mCxt);
        connectStatus = connectionCheck.isConnected(mCxt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);
        username = view.findViewById(R.id.username);
        userdob = view.findViewById(R.id.userdob);
        userdesignation = view.findViewById(R.id.userdepartment);
        userphone = view.findViewById(R.id.userphone);
        useremail = view.findViewById(R.id.useremail);
        lastSyncDateTime = view.findViewById(R.id.lastSyncDateTime);
        userDetails();
        getcurrentDatetime();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        prepareData();
        GridLayoutManager gd = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gd);
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, data);
        recyclerView.setAdapter(customAdapter);
        syncData = new GetSyncData(mCxt);
    }

    private ArrayList<DataSet> prepareData() {
        data = new ArrayList<>();
        for (int i = 0; i < arrayNames.length; i++) {
            DataSet dataSet = new DataSet();
            dataSet.setName(arrayNames[i]);
            dataSet.setImage(drawableArray[i]);
            data.add(dataSet);
        }
        return data;
    }

    public void userDetails() {
        String rolename = "", person_fullname = "", dob = "", marital_status = "",
                gender = "", email = "", mobile = "", dept = "", designation = "";
        Cursor c = db.gettingAllUserData();
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    rolename = c.getString(c.getColumnIndex("rolename"));
                    person_fullname = c.getString(c.getColumnIndex("person_fullname"));
                    dob = c.getString(c.getColumnIndex("dob"));
                    marital_status = c.getString(c.getColumnIndex("marital_status"));
                    gender = c.getString(c.getColumnIndex("gender"));
                    email = c.getString(c.getColumnIndex("email"));
                    mobile = c.getString(c.getColumnIndex("mobile"));
                    dept = c.getString(c.getColumnIndex("dept"));
                } while (c.moveToNext());
            }
        }
        c.close();
        username.setText(person_fullname);
        // userdob.setText(rolename);
        userdesignation.setText(dept);
        userphone.setText(mobile);
        useremail.setText(email);

    }

    private void getcurrentDatetime() {

        String date = "", time = "";
        Cursor c = db.getSyncDatetime();
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    date = c.getString(c.getColumnIndex("date"));
                    time = c.getString(c.getColumnIndex("time"));

                } while (c.moveToNext());
            }
        }
        c.close();
        lastSyncDateTime.setText(date + " " + time);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_sync) {
            if (connectStatus != NetworkUtils.TYPE_NOT_CONNECTED) {
                syncData.getDataSync();
            } else {
                Constants.customToast(mCxt, "Internet is not available", 2);
            }
        } else if (id == R.id.nav_logout) {
            dataSyncNotification();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void dataSyncNotification() {
        Cursor cursor = db.getAllTakeStudentAttendance();
        cursor.getCount();
        if (cursor.getCount() == 0) {
            userLogoutDialog();
        } else {
            Constants.customToast(mCxt, "Sync Your Data First", 2);
        }
    }

    public void userLogoutDialog() {
        final Dialog dialog = new Dialog(mCxt, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(layoutParams);

        ImageView titleImage = dialog
                .findViewById(R.id.title_icon);
        TextView txtTitle = dialog
                .findViewById(R.id.txt_dialog_title);
        TextView txtMessage = dialog
                .findViewById(R.id.text_dialog);
        Button left, right;
        left = dialog.findViewById(R.id.btn_cancel);
        right = dialog.findViewById(R.id.Ok_btn);
        titleImage.setImageDrawable(mCxt.getResources().getDrawable(
                R.drawable.man));

        txtTitle.setText("Logout");
        txtMessage.setText("Do you really want to Logout ?");
        left.setText("No");
        right.setText("Yes");
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                Logout_User();
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void Logout_User() {
        DataBaseManipulate db = new DataBaseManipulate(mCxt);
        SharedPreferences sharedpreferences = mCxt.getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
        Constants.clearpreference(mCxt, "HometoLogin");
        db.Alldelete(DataBaseManipulate.LOGIN_USERDETAIL);
        editor.clear();
        editor.commit();
        Intent intent = new Intent(mCxt, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mCxt.startActivity(intent);
        finish();
    }
}
