package com.rcdu.medu.attendancereport;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.attendance.TakeAttendanceList;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.common.Variables;
import com.rcdu.medu.rest.ApiClient;
import com.rcdu.medu.rest.ApiInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DateWiseReportDetailsActivity extends AppCompatActivity {


    Context mCtx;
    RecyclerView recycler_attendance;
    ArrayList<AttendanceDateWiseReportModel> mAttendanceReportArrayList;

    AttenDanceDateWiseReportAdapter mAttenDanceDateWiseReportAdapter;
    String paperId, subjectId, semesterId, classtypeId, sectionId;

    String teacherId, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datewise_report_details);
        initData();
    }

    public void initData() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Date Wise List");
        setSupportActionBar(toolbar);

        mCtx = DateWiseReportDetailsActivity.this;
        recycler_attendance = findViewById(R.id.recycler_attendance);
        if (getIntent() != null) {
            paperId = getIntent().getStringExtra("paperId");
            subjectId = getIntent().getStringExtra("subjectId");
            semesterId = getIntent().getStringExtra("semesterId");
            classtypeId = getIntent().getStringExtra("classtypeId");
            sectionId = getIntent().getStringExtra("sectionId");
            date = getIntent().getStringExtra("date");
            teacherId = Constants.getPrefrence(mCtx, "User_id");
        }

        getAttendancedata();
    }

    public void getAttendancedata() {
        try {
            ApiInterface apiInterface;
            final ProgressDialog dialog;
            int version_code = Variables.getApplicationVersionCode(mCtx);
            String version_name = Variables.getApplicationVersionName(mCtx);
            dialog = new ProgressDialog(mCtx, R.style.DialogSlideAnim);
            dialog.setMessage("Please wait,loading data");
            dialog.setCancelable(false);
            dialog.show();
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<JsonObject> call = apiInterface.getAttendanceDatewiseData(date, teacherId, subjectId, semesterId, sectionId, classtypeId);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    try {
                        mAttendanceReportArrayList = new ArrayList<>();
                        mAttendanceReportArrayList.clear();
                        int code = response.code();
                        if (code == 200) {
                            JsonObject mResponseBody1 = response.body();
                            JsonArray mResponseBody = mResponseBody1.getAsJsonArray("response");

                            JsonArray attendance_dataArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("attendance_data");


                            for (int attendance_data = 0; attendance_data < attendance_dataArray.size(); attendance_data++) {

                                String student_name = attendance_dataArray.get(attendance_data).getAsJsonObject().get("student_name").getAsString();
                                String college_roll = attendance_dataArray.get(attendance_data).getAsJsonObject().get("college_roll").getAsString();
                                String total_attended = attendance_dataArray.get(attendance_data).getAsJsonObject().get("total_attended").getAsString();
                                String total_held = attendance_dataArray.get(attendance_data).getAsJsonObject().get("total_held").getAsString();

                                AttendanceDateWiseReportModel attendanceDateWiseReportModel = new AttendanceDateWiseReportModel();
                                attendanceDateWiseReportModel.setStudent_name(student_name);
                                attendanceDateWiseReportModel.setCollege_roll(college_roll);
                                attendanceDateWiseReportModel.setTotal_attended(total_attended);
                                attendanceDateWiseReportModel.setTotal_held(total_held);
                                mAttendanceReportArrayList.add(attendanceDateWiseReportModel);

                            }
                            dialog.dismiss();
                            mAttenDanceDateWiseReportAdapter = new AttenDanceDateWiseReportAdapter(mCtx, mAttendanceReportArrayList);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx);
                            recycler_attendance.setLayoutManager(layoutManager);
                            recycler_attendance.setAdapter(mAttenDanceDateWiseReportAdapter);
                            recycler_attendance.setItemViewCacheSize(mAttendanceReportArrayList.size());
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    dialog.dismiss();
                    call.cancel();

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(mCtx, DateWiseReportActivity.class);
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
            Intent intent = new Intent(DateWiseReportDetailsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
