package com.rcdu.medu.attendance;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TakeAttendacne extends AppCompatActivity {

    private AppCompatEditText edit_select_date;
    private AppCompatSpinner spinner_paper_type,
            spinner_subject, spinner_semester, spinner_classtype,
            spinner_section;
    private AppCompatButton attandance_submit_btn;

    private SimpleDateFormat sdf;
    private Calendar myCalendar = Calendar.getInstance();
    private int p = 0;
    private Context mCtx;
    DataBaseManipulate dm;
    int paper_id = 0, subject_id = 0, semester_id = 0, classtype_id = 0, section_id = 0;
    String Strpaper, Strsubject, Strsemeste, Strclasstype, Strsection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        intializedParam();
        initDate();
        attandance_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub_id = "";
                if (edit_select_date.getText().toString().isEmpty()) {
                    Constants.customToast(mCtx, "Please select date", 2);
                } else {
                    int count = dm.checkAttendanceTableCount(edit_select_date.getText().toString(), Strpaper,
                            Strsubject, Strsemeste, Strclasstype, Strsection);
                    if (count > 0) {
                        userAttendanceCountDialog();
                    } else {
                        Intent intent = new Intent(mCtx, StudentAttendace.class);
                        intent.putExtra("date", edit_select_date.getText().toString());
                        intent.putExtra("paperId", Strpaper);
                        intent.putExtra("subjectId", Strsubject);
                        intent.putExtra("semesterId", Strsemeste);
                        intent.putExtra("classtypeId", Strclasstype);
                        intent.putExtra("sectionId", Strsection);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    private void intializedParam() {
        mCtx = TakeAttendacne.this;
        dm = new DataBaseManipulate(mCtx);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Take Attendance ");
        setSupportActionBar(toolbar);
        edit_select_date = findViewById(R.id.edit_select_date);
        spinner_paper_type = findViewById(R.id.spinner_paper_type);
        spinner_subject = findViewById(R.id.spinner_subject);
        spinner_semester = findViewById(R.id.spinner_semester);
        spinner_classtype = findViewById(R.id.spinner_classtype);
        spinner_section = findViewById(R.id.spinner_section);
        attandance_submit_btn = findViewById(R.id.attandance_submit_btn);
        Cursor cur = dm.getAllPaperType();

        SimpleCursorAdapter ca = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur, new String[]{
                "name", "_id"}, new int[]{R.id.txtDeptName}, 0);
        spinner_paper_type.setAdapter(ca);

        Cursor cur3 = dm.getAllClassType();

        SimpleCursorAdapter ca3 = new SimpleCursorAdapter(mCtx,
                R.layout.deptspinnerrow, cur3, new String[]{
                "name", "_id"}, new int[]{R.id.txtDeptName}, 0);
        spinner_classtype.setAdapter(ca3);


        spinner_paper_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                paper_id = (int) spinner_paper_type.getSelectedItemId();
                Strpaper = "" + paper_id;
                getSubject(Strpaper);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                subject_id = (int) spinner_subject.getSelectedItemId();
                Strsubject = "" + subject_id;

                getSemester(Strsubject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester_id = (int) spinner_semester.getSelectedItemId();
                Strsemeste = "" + semester_id;
                getSection(Strsemeste);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_classtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classtype_id = (int) spinner_classtype.getSelectedItemId();
                Strclasstype = "" + classtype_id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                section_id = (int) spinner_section.getSelectedItemId();
                Strsection = "" + section_id;

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

        // Cursor cur4 = dm.getAllSection(semester_id);
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
                    edit_select_date.setText("");

                } else {
                    switch (p) {
                        case 0:
                            edit_select_date.setText(sdf.format(myCalendar.getTime()));
                            break;
                        default:
                            break;
                    }
                }
            }
        };
        edit_select_date.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(mCtx, TakeAttendanceList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    public void userAttendanceCountDialog() {
        final Dialog dialog = new Dialog(mCtx, R.style.DialogSlideAnim);
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
        titleImage.setImageDrawable(mCtx.getResources().getDrawable(
                R.drawable.man));

        txtTitle.setText("You have already submitted attendance");
        txtMessage.setText("Do you want submit again ?");
        left.setText("No");
        right.setText("Yes");

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mCtx, AttendanceEditActivity.class);
                intent.putExtra("date", edit_select_date.getText().toString());
                intent.putExtra("paperId", Strpaper);
                intent.putExtra("subjectId", Strsubject);
                intent.putExtra("semesterId", Strsemeste);
                intent.putExtra("classtypeId", Strclasstype);
                intent.putExtra("sectionId", Strsection);
                startActivity(intent);
                dialog.dismiss();

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home_) {
            Intent intent = new Intent(TakeAttendacne.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
