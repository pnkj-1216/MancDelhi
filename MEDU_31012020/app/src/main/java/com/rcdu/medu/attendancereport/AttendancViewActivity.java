package com.rcdu.medu.attendancereport;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.attendance.TakeAttendanceList;
import com.rcdu.medu.common.Constants;

public class AttendancViewActivity extends AppCompatActivity {

    private AppCompatButton date_attendance_btn, month_attendance_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendanc_view);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Attendance View ");
        setSupportActionBar(toolbar);

        date_attendance_btn = findViewById(R.id.date_attendance_btn);
        month_attendance_btn = findViewById(R.id.month_attendance_btn);



        date_attendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendancViewActivity.this, DateWiseReportActivity.class);
                startActivity(intent);
            }
        });

        month_attendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AttendancViewActivity.this, MonthWiseReportActivity.class);
                startActivity(intent);

               // Constants.customToast(AttendancViewActivity.this,"Comming soon...",2);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(AttendancViewActivity.this, TakeAttendanceList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home_) {
            Intent intent = new Intent(AttendancViewActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
