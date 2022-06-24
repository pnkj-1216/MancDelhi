package com.rcdu.medu.attendancereport;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MonthWiseReportActivity extends AppCompatActivity {

    private AppCompatTextView select_month;
    private AppCompatSpinner spinner_paper_type,
            spinner_subject, spinner_semester, spinner_classtype,
            spinner_section;
    private AppCompatButton attandance_submit_btn;
    private Context mCtx;
    DataBaseManipulate dm;
    String paperId, subjectId, semesterId, classtypeId, sectionId;
    int mMonth, mYear, mDay;
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM, yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_wise_report);


        intializedParam();
        attandance_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (select_month.getText().toString().isEmpty()) {
                    Constants.customToast(mCtx, "Please select date", 2);
                } else {
                    Intent intent = new Intent(mCtx, MonthWiseReportDatailsActivity.class);
                    intent.putExtra("month", select_month.getText().toString());
                    intent.putExtra("paperId", paperId);
                    intent.putExtra("subjectId", subjectId);
                    intent.putExtra("semesterId", semesterId);
                    intent.putExtra("classtypeId", classtypeId);
                    intent.putExtra("sectionId", sectionId);
                    startActivity(intent);
                }
            }
        });

        select_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final MonthlyYearPicker monthYearPicker = new MonthlyYearPicker(MonthWiseReportActivity.this);
                monthYearPicker.build(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedMonth = String.valueOf(monthYearPicker.getSelectedMonth() + 1);
                        String selectedDate1 = monthYearPicker.getSelectedMonthName() + "," + monthYearPicker.getSelectedYear();

                        DateFormat df1 = new SimpleDateFormat("MMMM,yyyy");
                        mMonth = monthYearPicker.getSelectedMonth() + 1;
                      String month=String.valueOf(mMonth);
                      if(!month.equals(10) || !month.equals(11) || !month.equals(12)){
                          month="0"+month;
                      }
                        mYear = monthYearPicker.getSelectedYear();
                        select_month.setText(String.valueOf(mYear)+"-"+month);
                    }
                },
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                monthYearPicker.show();
            }
        });
    }

    private void intializedParam() {
        mCtx = MonthWiseReportActivity.this;
        dm = new DataBaseManipulate(mCtx);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Month Wise Report");
        setSupportActionBar(toolbar);

        select_month = findViewById(R.id.select_month);
        spinner_paper_type = findViewById(R.id.spinner_paper_type);
        spinner_subject = findViewById(R.id.spinner_subject);
        spinner_semester = findViewById(R.id.spinner_semester);
        spinner_classtype = findViewById(R.id.spinner_classtype);
        spinner_section = findViewById(R.id.spinner_section);
        attandance_submit_btn = findViewById(R.id.attandance_submit_btn);

        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH) + 1;
        String selectedDate = String.valueOf(new StringBuilder().append(mYear).append("-")
                // Month is 0 based, just add 1
                .append(mMonth + 1).append("-").append(mDay));

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dt.parse(selectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        select_month.setText(monthFormat.format(date));


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


    public void getSubject(String paper_type_id) {
        Cursor cur1 = dm.getAllSubject(paper_type_id);

        SimpleCursorAdapter ca1 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur1, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_subject.setAdapter(ca1);
    }

    public void getSemester(String subject_id) {
        Cursor cur2 = dm.getAllSemester(subject_id);

        SimpleCursorAdapter ca2 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur2, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_semester.setAdapter(ca2);
    }

    public void getSection(String semester_id) {
        //  Cursor cur4 = dm.getAllSection(semester_id);
        Cursor cur4 = dm.getAllType();

        SimpleCursorAdapter ca4 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur4, new String[]{
                "name", "_id"},
                new int[]{R.id.txtDeptName}, 0);
        spinner_section.setAdapter(ca4);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MonthWiseReportActivity.this, AttendancViewActivity.class);
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
            Intent intent = new Intent(MonthWiseReportActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
