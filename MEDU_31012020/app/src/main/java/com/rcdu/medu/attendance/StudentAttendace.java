package com.rcdu.medu.attendance;


import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.allSyncMethod.GetSyncData;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.connectivity.ConnectionCheck;
import com.rcdu.medu.connectivity.NetworkUtils;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;
import com.rcdu.medu.modelclass.StudentAttendanceModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentAttendace extends AppCompatActivity {
    private AppCompatTextView attendance_date;
    private AppCompatEditText lecture_edittext;
    public AppCompatCheckBox sellectall;
    private RecyclerView recycler_attendance;
    private StudentAttendanceAdapter madapter;
    private DataBaseManipulate dm;
    private ArrayList<StudentAttendanceModel> arrayList;
    private String currentDate;
    StudentAttendanceModel attendanceModel;
    private Context mCxt;
    private AppCompatButton attandance_submit_btn;
    long attn = -1;
    ConnectionCheck connectionCheck;
    GetSyncData syncData;
    String paperId, subjectId, semesterId, classtypeId, sectionId;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendace);
        intializedParams();
        lecture_edittext.setText("1");
        setdataList("1", true);
        sellectall.setChecked(true);
        setMadapter();

        lecture_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (lecture_edittext.getText().toString().equals("")) {
                    setdataList("0", false);
                    sellectall.setChecked(false);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                } else if (!lecture_edittext.getText().toString().equals("1")) {
                    setdataList(s.toString(), true);
                    sellectall.setChecked(true);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                } else {
                    setdataList(s.toString(), true);
                    sellectall.setChecked(true);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sellectall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    setdataList(lecture_edittext.getText().toString(), true);
                    sellectall.setChecked(true);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                } else {
                    setdataList(lecture_edittext.getText().toString(), false);
                    sellectall.setChecked(false);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void intializedParams() {
        mCxt = StudentAttendace.this;
        dm = new DataBaseManipulate(mCxt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Mark Attendance");
        setSupportActionBar(toolbar);
        syncData = new GetSyncData(mCxt);
        attendance_date = findViewById(R.id.attendance_date);
        lecture_edittext = findViewById(R.id.lecture_edittext);
        sellectall = findViewById(R.id.sellectall);
        recycler_attendance = findViewById(R.id.recycler_attendance);
        attandance_submit_btn = findViewById(R.id.attandance_submit_btn);
        currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        if (getIntent() != null) {
            paperId = getIntent().getStringExtra("paperId");
            subjectId = getIntent().getStringExtra("subjectId");
            semesterId = getIntent().getStringExtra("semesterId");
            classtypeId = getIntent().getStringExtra("classtypeId");
            sectionId = getIntent().getStringExtra("sectionId");
            currentDate = getIntent().getStringExtra("date");
            value = getIntent().getStringExtra("key");
        }
        attendance_date.setText(currentDate);
        attandance_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(lecture_edittext.getText().toString().trim(), currentDate, String.valueOf(arrayList.size()));

            }
        });
    }

    private void setdataList(String lecture, boolean checkb) {
        arrayList = new ArrayList<>();
        arrayList.clear();

        Cursor c = dm.getAllStudnetDetails(paperId, subjectId, semesterId, sectionId);
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    String paper_id = c.getString(c.getColumnIndex("paper_type_id"));
                    String course_id = c.getString(c.getColumnIndex("course_id"));
                    String subject_id = c.getString(c.getColumnIndex("subject_id"));
                    String semester_id = c.getString(c.getColumnIndex("semester_id"));
                    String section_id = c.getString(c.getColumnIndex("section_id"));
                    String student_id = c.getString(c.getColumnIndex("student_id"));
                    String student_name = c.getString(c.getColumnIndex("student_name"));
                    String college_roll = c.getString(c.getColumnIndex("college_roll"));

                    attendanceModel = new StudentAttendanceModel(paper_id, course_id,
                            subject_id, semester_id, section_id, student_id, student_name, college_roll, lecture, checkb);
                    arrayList.add(attendanceModel);

                } while (c.moveToNext());
            }
        }
        c.close();

    }

    private void setMadapter() {
        if (arrayList.isEmpty()) {
            recycler_attendance.setVisibility(View.GONE);
            lecture_edittext.setText("");
            lecture_edittext.setEnabled(false);
            attandance_submit_btn.setVisibility(View.INVISIBLE);
            sellectall.setVisibility(View.INVISIBLE);
            Constants.customToast(mCxt, "Data is not available on this section", 2);
        } else {
            madapter = new StudentAttendanceAdapter(mCxt, arrayList);
            LinearLayoutManager manager = new LinearLayoutManager(mCxt);
            recycler_attendance.setAdapter(madapter);
            recycler_attendance.setLayoutManager(manager);
            recycler_attendance.setItemViewCacheSize(arrayList.size());
            madapter.notifyDataSetChanged();
        }
    }

    private void setSubmitData() {

        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());


        for (StudentAttendanceModel studentAttendanceModel : arrayList) {
            String attendence_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + studentAttendanceModel.getStudent_id();
            String attended_lecture;
            String attendence_status = "";
            if (studentAttendanceModel.isCheck()) {
                attendence_status = "1";
                if (studentAttendanceModel.getFilleditbox() == null) {
                    attended_lecture = studentAttendanceModel.getLecture();
                } else {
                    attended_lecture = studentAttendanceModel.getFilleditbox();
                }
            } else {
                attendence_status = "0";
                attended_lecture = "0";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.clear();
            contentValues.put("attendence_id", attendence_id);
            contentValues.put("attendence_date", attendance_date.getText().toString());
            contentValues.put("attendence_status", attendence_status);
            contentValues.put("attendence_total_held", lecture_edittext.getText().toString());
            contentValues.put("semester_id", studentAttendanceModel.getSemester_id());
            contentValues.put("student_id", studentAttendanceModel.getStudent_id());
            contentValues.put("lecture_attended", attended_lecture);
            contentValues.put("sub_id", studentAttendanceModel.getSubject_id());
            contentValues.put("section_id", studentAttendanceModel.getSection_id());
            contentValues.put("course_id", studentAttendanceModel.getCourse_id());
            contentValues.put("attendence_time", currentTime);
            contentValues.put("attendence_created_datetime", currentDate + " " + currentTime);
            contentValues.put("class_type_id", classtypeId);
            attn = dm.InsertData(DataBaseManipulate.TAKE_STUDENT_ATTENDANCE, contentValues, "id");
            if (attn > 0) {
                dm.insertStatusOfSyncData();
            }
        }
        int connectStatus = connectionCheck.isConnected(mCxt);
        if (connectStatus != NetworkUtils.TYPE_NOT_CONNECTED) {
            syncData.getDataSync();
        } else {
            Constants.customToast(mCxt, "Attendance Submitted Offline", 0);
            Intent intent = new Intent(mCxt, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(
                    R.anim.animation_enter_from_right,
                    R.anim.animation_leave_out_to_left);

        }
    }

    public void showDialog(final String lecture, String current_date, String students_count) {
        final Dialog dialog = new Dialog(mCxt, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.student_layout_dialog);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(layoutParams);

        TextView date = dialog.findViewById(R.id.date);
        TextView lectures = dialog.findViewById(R.id.lectures);
        TextView students = dialog.findViewById(R.id.students);
        TextView present = dialog.findViewById(R.id.present);
        TextView absent = dialog.findViewById(R.id.absent);
        int present_count = 0;
        int absent_count = 0;

        for (StudentAttendanceModel studentAttendanceModel : arrayList) {

            if (studentAttendanceModel.isCheck) {
                present_count++;
            } else {
                absent_count++;
            }

        }
        present.setText(String.valueOf(present_count));
        absent.setText(String.valueOf(absent_count));
        Button recheck_btn = dialog.findViewById(R.id.btn_yes);
        Button submit_btn = dialog.findViewById(R.id.btn_no);

        date.setText(current_date);
        lectures.setText(lecture);
        students.setText(students_count);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        recheck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSubmitData();
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(mCxt, TakeAttendacne.class);
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
            Intent intent = new Intent(StudentAttendace.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
