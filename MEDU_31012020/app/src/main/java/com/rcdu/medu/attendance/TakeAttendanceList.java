package com.rcdu.medu.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.attendancereport.AttendancViewActivity;

public class TakeAttendanceList extends AppCompatActivity {

    Button take_attendance_btn;
    Button edit_attendance_btn;
    Button report_attendance_btn;
    Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Take List");
        setSupportActionBar(toolbar);

        intializedParams();

        take_attendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, TakeAttendacne.class);
                startActivity(intent);
                overridePendingTransition(
                        R.anim.animation_enter_from_right,
                        R.anim.animation_leave_out_to_left);
            }
        });

        edit_attendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mCtx, EditAttendanceActivity.class);
                startActivity(intent);
                overridePendingTransition(
                        R.anim.animation_enter_from_right,
                        R.anim.animation_leave_out_to_left);
            }
        });

        report_attendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mCtx, AttendancViewActivity.class);
                startActivity(intent);
                overridePendingTransition(
                        R.anim.animation_enter_from_right,
                        R.anim.animation_leave_out_to_left);

            }
        });
    }

    private void intializedParams() {
        mCtx = TakeAttendanceList.this;
        take_attendance_btn = findViewById(R.id.take_attendance_btn);
        edit_attendance_btn = findViewById(R.id.edit_attendance_btn);
        report_attendance_btn = findViewById(R.id.report_attendance_btn);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TakeAttendanceList.this, MainActivity.class);
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
            Intent intent = new Intent(TakeAttendanceList.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

}
