package com.rcdu.medu.attendancereport;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;

import com.rcdu.medu.attendance.TakeAttendanceList;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateWiseReportActivity extends AppCompatActivity {

    private AppCompatEditText select_date;
    private AppCompatSpinner spinner_paper_type,
            spinner_subject, spinner_semester, spinner_classtype,
            spinner_section;
    private AppCompatButton attandance_submit_btn;
    private AppCompatTextView slecttextview;

    private SimpleDateFormat sdf;
    private Calendar myCalendar = Calendar.getInstance();
    private int p = 0;
    private Context mCtx;
    DataBaseManipulate dm;
    String date;
    String paperId, subjectId, semesterId, classtypeId, sectionId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datewise_report);

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        intializedParam();
        initDate();


        attandance_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (select_date.getText().toString().isEmpty()) {
                    Constants.customToast(mCtx, "Please select date", 2);
                } else {
                    Intent intent = new Intent(mCtx, DateWiseReportDetailsActivity.class);
                    intent.putExtra("date", select_date.getText().toString());
                    intent.putExtra("paperId", paperId);
                    intent.putExtra("subjectId", subjectId);
                    intent.putExtra("semesterId", semesterId);
                    intent.putExtra("classtypeId", classtypeId);
                    intent.putExtra("sectionId", sectionId);
                    startActivity(intent);
                }
            }
        });
    }

    private void intializedParam() {
        mCtx = DateWiseReportActivity.this;
        dm = new DataBaseManipulate(mCtx);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Date Wise Report");
        setSupportActionBar(toolbar);

        select_date = findViewById(R.id.select_date);
        spinner_paper_type = findViewById(R.id.spinner_paper_type);
        spinner_subject = findViewById(R.id.spinner_subject);
        spinner_semester = findViewById(R.id.spinner_semester);
        spinner_classtype = findViewById(R.id.spinner_classtype);
        spinner_section = findViewById(R.id.spinner_section);
        slecttextview = findViewById(R.id.slecttextview);
        attandance_submit_btn = findViewById(R.id.attandance_submit_btn);

        Cursor cur = dm.getAllPaperType();
        SimpleCursorAdapter ca = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_paper_type.setAdapter(ca);



        Cursor cur3 = dm.getAllClassType();
        SimpleCursorAdapter ca3 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur3, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_classtype.setAdapter(ca3);




        spinner_paper_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int paper_id = (int) spinner_paper_type.getSelectedItemId();
                paperId = "" + paper_id;
                getSubject(paperId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int subject_id = (int) spinner_subject.getSelectedItemId();
                subjectId = "" + subject_id;
                getSemester(subjectId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int semester_id = (int) spinner_semester.getSelectedItemId();
                semesterId = "" + semester_id;
                getSection(semesterId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_classtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int classtype_id = (int) spinner_classtype.getSelectedItemId();
                classtypeId = "" + classtype_id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int section_id = (int) spinner_section.getSelectedItemId();
                sectionId = "" + section_id;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void getSubject(String paper_type_id){
        Cursor cur1 = dm.getAllSubject(paper_type_id);

        SimpleCursorAdapter ca1 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur1, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_subject.setAdapter(ca1);
    }

    public void getSemester(String subject_id){
        Cursor cur2 = dm.getAllSemester(subject_id);

        SimpleCursorAdapter ca2 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur2, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_semester.setAdapter(ca2);
    }

    public void getSection(String semester_id) {

        //Cursor cur4 = dm.getAllSection(semester_id);
        Cursor cur4 = dm.getAllType();
            SimpleCursorAdapter ca4 = new SimpleCursorAdapter(mCtx,
                    R.layout.deptspinnerrow, cur4, new String[]{
                    "name", "_id"},
                    new int[]{R.id.txtDeptName}, 0);
            spinner_section.setAdapter(ca4);

    }


    private void initDate() {

        final DatePickerDialog.OnDateSetListener odsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);

                if (myCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    Constants.customToast(mCtx, "Can't select sunday", 2);
                    select_date.setText("");

                } else {
                    switch (p) {
                        case 0:
                            select_date.setText(sdf.format(myCalendar.getTime()));
                            break;
                        default:
                            break;
                    }
                }
            }
        };
        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = 0;
                Calendar cal = Calendar.getInstance();
                DatePickerDialog datePickDiag = new DatePickerDialog(mCtx,
                        odsl, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH));
                datePickDiag.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickDiag.show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(DateWiseReportActivity.this, AttendancViewActivity.class);
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
            Intent intent = new Intent(DateWiseReportActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
