package com.rcdu.medu.attendancereport;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.GsonBuilder;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.common.Variables;
import com.rcdu.medu.modelclass.Student;
import com.rcdu.medu.rest.ApiClient;
import com.rcdu.medu.rest.ApiInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonthWiseReportDatailsActivity extends AppCompatActivity {

    Context mCtx;
    RecyclerView recycler_monthwise;
    public static ArrayList<Student> mAttendanceReportArrayList;

    MonthWiseReportAdapter mAttenDanceDateWiseReportAdapter;
    String paperId, subjectId, semesterId, classtypeId, sectionId;
    String teacherId, month;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_wise_report_datails);
        initData();
    }
    public void initData() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Monthly Attendance Summary");
        setSupportActionBar(toolbar);
        mCtx = MonthWiseReportDatailsActivity.this;
        teacherId = Constants.getPrefrence(mCtx, "User_id");
        if (getIntent() != null) {
            paperId = getIntent().getStringExtra("paperId");
            subjectId = getIntent().getStringExtra("subjectId");
            semesterId = getIntent().getStringExtra("semesterId");
            classtypeId = getIntent().getStringExtra("classtypeId");
            sectionId = getIntent().getStringExtra("sectionId");
            month = getIntent().getStringExtra("month");
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
            Call<JsonObject> call = apiInterface.getAttendanceMonthwiseData(month, teacherId, subjectId, semesterId, sectionId, classtypeId);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    try {
                        mAttendanceReportArrayList = new ArrayList<>();
                        mAttendanceReportArrayList.clear();
                        int code = response.code();
                        if (code == 200) {
                            JsonObject mResponseBody1 = response.body();
                            if (mResponseBody1.get("response").getAsBoolean()) {
                                dialog.dismiss();
                                JsonArray student = mResponseBody1.get("student").getAsJsonArray();
                                if (student.size() > 0) {
                                    for (int i = 0; i < student.size(); i++) {
                                        Student student1 = new GsonBuilder().create().fromJson(student.get(i), Student.class);
                                        mAttendanceReportArrayList.add(student1);
                                    }

                                    ViewGroup tab = findViewById(R.id.tab);
                                    tab.addView(LayoutInflater.from(MonthWiseReportDatailsActivity.this).inflate(R.layout.tabviewpager, tab, false));
                                    ViewPager viewPager = findViewById(R.id.viewPager);
                                    SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab);

                                    FragmentPagerItems pages = new FragmentPagerItems(MonthWiseReportDatailsActivity.this);
                                    for (int i = 0; i < mAttendanceReportArrayList.size(); i++) {
                                        pages.add(FragmentPagerItem.of(mAttendanceReportArrayList.get(i).getStudentName() + "\n" + "[" + mAttendanceReportArrayList.get(i).getCollegeRoll() + "]", StatusFragment.class));

                                    }
                                    FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
                                    viewPager.setAdapter(adapter);
                                    viewPagerTab.setSelectedIndicatorColors(Color.YELLOW);
                                    viewPagerTab.setViewPager(viewPager);

                                }
                            } else {
                                dialog.dismiss();
                                Constants.customToast(mCtx, "Data not found on selected Month", 2);

                            }


//                            JsonArray attendance_dataArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("attendance_data");
//                            for (int attendance_data = 0; attendance_data < attendance_dataArray.size(); attendance_data++) {
//
//                                String student_name = attendance_dataArray.get(attendance_data).getAsJsonObject().get("student_name").getAsString();
//                                String college_roll = attendance_dataArray.get(attendance_data).getAsJsonObject().get("college_roll").getAsString();
//                                String total_attended = attendance_dataArray.get(attendance_data).getAsJsonObject().get("total_attended").getAsString();
//                                String total_held = attendance_dataArray.get(attendance_data).getAsJsonObject().get("total_held").getAsString();
//
//                                AttendanceMonthWiseReportModel attendanceMonthWiseReportModel = new AttendanceMonthWiseReportModel();
//                                attendanceMonthWiseReportModel.setStudent_name(student_name);
//                                attendanceMonthWiseReportModel.setCollege_roll(college_roll);
//                                attendanceMonthWiseReportModel.setTotal_attended(total_attended);
//                                attendanceMonthWiseReportModel.setTotal_held(total_held);
//                                mAttendanceReportArrayList.add(attendanceMonthWiseReportModel);

                            // }
//                            dialog.dismiss();
//                            mAttenDanceDateWiseReportAdapter = new MonthWiseReportAdapter(mCtx, mAttendanceReportArrayList);
//                            LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx);
//                            recycler_monthwise.setLayoutManager(layoutManager);
//                            recycler_monthwise.setAdapter(mAttenDanceDateWiseReportAdapter);
//                            recycler_monthwise.setItemViewCacheSize(mAttendanceReportArrayList.size());
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home_) {
            Intent intent = new Intent(MonthWiseReportDatailsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
