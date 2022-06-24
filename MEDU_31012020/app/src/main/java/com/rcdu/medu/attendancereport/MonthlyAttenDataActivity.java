package com.rcdu.medu.attendancereport;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.R;
import com.rcdu.medu.modelclass.Attendance;

import java.util.ArrayList;

public class MonthlyAttenDataActivity extends AppCompatActivity {
    RecyclerView recycler_monthwisedata;
    ArrayList<Attendance> attendanceArrayList;
    MonthlyAttenDataAdapter monthlyAttenDataAdapter;
    Context mCxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_atten_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Monthly Attendance Report");
        setSupportActionBar(toolbar);
        recycler_monthwisedata=findViewById(R.id.recycler_monthwisedata);
        attendanceArrayList=new ArrayList<>();
        attendanceArrayList.clear();
        if (getIntent()!=null){

            attendanceArrayList=getIntent().getParcelableArrayListExtra("data");
        }


        MonthlyAttenDataAdapter attenDataAdapter=new MonthlyAttenDataAdapter(MonthlyAttenDataActivity.this,attendanceArrayList);
        LinearLayoutManager manager=new LinearLayoutManager(mCxt);
        recycler_monthwisedata.setLayoutManager(manager);
        recycler_monthwisedata.setAdapter(attenDataAdapter);
        recycler_monthwisedata.setItemViewCacheSize(attendanceArrayList.size());
    }
}
