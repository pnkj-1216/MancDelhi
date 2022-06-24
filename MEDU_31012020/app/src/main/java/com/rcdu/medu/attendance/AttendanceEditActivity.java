package com.rcdu.medu.attendance;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
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
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.common.Variables;
import com.rcdu.medu.connectivity.ConnectionCheck;
import com.rcdu.medu.connectivity.NetworkUtils;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;
import com.rcdu.medu.modelclass.EditAttendanceData;
import com.rcdu.medu.rest.ApiClient;
import com.rcdu.medu.rest.ApiInterface;
import com.rcdu.medu.writeExternalStorage.WriteDataFille;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceEditActivity extends AppCompatActivity {

    private AppCompatTextView attendance_date;
    private AppCompatEditText lecture_edittext;
    AppCompatCheckBox sellectall;
    private RecyclerView recycler_attendance;
    private EditAttendanceDataAdapter madapter;
    private ArrayList<EditAttendanceData> arrayEditList;
    private String currentDate;
    private Spinner lectureSpinner;
    EditAttendanceData editAttendanceData;
    public static Context mCxt;
    private AppCompatButton attandanceedit_submit_btn;
    long attn = -1;
    ConnectionCheck connectionCheck;
    String paperId, subjectId, semesterId, classtypeId, sectionId;
    DataBaseManipulate dm;
    String teacherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_edit);
        intializedParams();
        teacherId = Constants.getPrefrence(mCxt, "User_id");
        getAttendancedata();
        getEditAttendanceDate(lecture_edittext.getText().toString(), true);
        setMadapter();
        //setSpinnerItem();

        lecture_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (lecture_edittext.getText().toString().equals("")) {
                    getEditAttendanceDate("0", false);
                    sellectall.setChecked(false);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                } else {
                    getEditAttendanceDate(s.toString(), true);
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
                    getEditAttendanceDate(lecture_edittext.getText().toString(), true);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                } else {
                    getEditAttendanceDate("0", false);
                    sellectall.setChecked(false);
                    setMadapter();
                    madapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void getEditAttendanceDate(String lecture, boolean checkb) {

        arrayEditList = new ArrayList<>();
        arrayEditList.clear();

        Cursor c = dm.getAllEditAttendanceData();
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    String status = c.getString(c.getColumnIndex("status"));
                    String update_count = c.getString(c.getColumnIndex("update_count"));
                    String attendance_id = c.getString(c.getColumnIndex("attendance_id"));
                    String attended = c.getString(c.getColumnIndex("attended"));
                    String total_held = c.getString(c.getColumnIndex("total_held"));
                    String subject_id = c.getString(c.getColumnIndex("subject_id"));
                    String date = c.getString(c.getColumnIndex("date"));
                    String college_roll = c.getString(c.getColumnIndex("college_roll"));
                    String student_id = c.getString(c.getColumnIndex("student_id"));
                    String student_name = c.getString(c.getColumnIndex("student_name"));

                    if (attended.equals("0")) {
                        checkb = false;
                        sellectall.setChecked(false);
                    } else {
                        checkb = true;
                    }
                    editAttendanceData = new EditAttendanceData(status, update_count,
                            attendance_id, total_held, attended, subject_id, date,
                            college_roll, student_id, student_name, lecture, checkb);
                    arrayEditList.add(editAttendanceData);

                } while (c.moveToNext());
            }
        }
        c.close();

        setMadapter();
    }

    private void intializedParams() {
        dm = new DataBaseManipulate(mCxt);
        mCxt = AttendanceEditActivity.this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Edit Attendance ");
        setSupportActionBar(toolbar);
        attendance_date = findViewById(R.id.attendance_date);
        lecture_edittext = findViewById(R.id.lecture_edittext);
        sellectall = findViewById(R.id.sellectall);
        sellectall.setEnabled(false);
        recycler_attendance = findViewById(R.id.recycler_attendance);
        attandanceedit_submit_btn = findViewById(R.id.attandanceedit_submit_btn);
        currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        if (getIntent() != null) {
            paperId = getIntent().getStringExtra("paperId");
            subjectId = getIntent().getStringExtra("subjectId");
            semesterId = getIntent().getStringExtra("semesterId");
            classtypeId = getIntent().getStringExtra("classtypeId");
            sectionId = getIntent().getStringExtra("sectionId");
            currentDate = getIntent().getStringExtra("date");
        }
        attendance_date.setText(currentDate);

        attandanceedit_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int connectStatus = connectionCheck.isConnected(mCxt);
                if (connectStatus != NetworkUtils.TYPE_NOT_CONNECTED) {
                    showDialog(lecture_edittext.getText().toString().trim(), currentDate, String.valueOf(arrayEditList.size()));
                } else {
                    Constants.showNetworkAlert(mCxt);
                }
            }
        });
    }

    private void setMadapter() {
        if (arrayEditList.isEmpty()) {
            recycler_attendance.setVisibility(View.GONE);
            lecture_edittext.setText("");
            lecture_edittext.setEnabled(false);
            attandanceedit_submit_btn.setVisibility(View.INVISIBLE);
            sellectall.setVisibility(View.INVISIBLE);
            Constants.customToast(mCxt, "Data is not available on this section", 2);
        } else {
            madapter = new EditAttendanceDataAdapter(mCxt, arrayEditList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mCxt);
            recycler_attendance.setLayoutManager(layoutManager);
            recycler_attendance.setAdapter(madapter);
            recycler_attendance.setItemViewCacheSize(arrayEditList.size());

        }
    }

    public void getAttendancedata() {
        try {
            ApiInterface apiInterface;
            final ProgressDialog dialog;
            int version_code = Variables.getApplicationVersionCode(mCxt);
            String version_name = Variables.getApplicationVersionName(mCxt);
            dialog = new ProgressDialog(mCxt, R.style.DialogSlideAnim);
            dialog.setMessage("Please wait,loading data");
            dialog.setCancelable(false);
            dialog.show();

            apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<JsonObject> call = apiInterface.getEditAttendanceData(currentDate, teacherId,
                    subjectId, semesterId, sectionId, classtypeId);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    try {
                        int code = response.code();
                        if (code == 200) {
                            JsonObject mResponseBody1 = response.body();
                            JsonArray mResponseBody = mResponseBody1.getAsJsonArray("result");
                            JsonArray attendance_editArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("attendance_edit");
                            dm.deletetable(DataBaseManipulate.EDIT_STUDENT_ATTENDANCE_DATA);


                            for (int attendance_data = 0; attendance_data < attendance_editArray.size(); attendance_data++) {

                                String status = attendance_editArray.get(attendance_data).getAsJsonObject().get("status").getAsString();
                                String update_count = attendance_editArray.get(attendance_data).getAsJsonObject().get("update_count").getAsString();
                                String attendance_id = attendance_editArray.get(attendance_data).getAsJsonObject().get("attendance_id").getAsString();
                                String total_held = attendance_editArray.get(attendance_data).getAsJsonObject().get("total_held").getAsString();
                                String attended = attendance_editArray.get(attendance_data).getAsJsonObject().get("attended").getAsString();
                                String subject_id = attendance_editArray.get(attendance_data).getAsJsonObject().get("subject_id").getAsString();
                                String date = attendance_editArray.get(attendance_data).getAsJsonObject().get("date").getAsString();
                                String college_roll = attendance_editArray.get(attendance_data).getAsJsonObject().get("college_roll").getAsString();
                                String student_id = attendance_editArray.get(attendance_data).getAsJsonObject().get("student_id").getAsString();
                                String student_name = attendance_editArray.get(attendance_data).getAsJsonObject().get("student_name").getAsString();

                                ContentValues contentValues = new ContentValues();
                                contentValues.clear();
                                contentValues.put("status", status);
                                contentValues.put("update_count", update_count);
                                contentValues.put("attendance_id", attendance_id);
                                contentValues.put("total_held", total_held);
                                contentValues.put("attended", attended);
                                contentValues.put("subject_id", subject_id);
                                contentValues.put("date", date);
                                contentValues.put("college_roll", college_roll);
                                contentValues.put("student_id", student_id);
                                contentValues.put("student_name", student_name);

                                attn = dm.InsertData(DataBaseManipulate.EDIT_STUDENT_ATTENDANCE_DATA, contentValues, "id");

                                lecture_edittext.setText(total_held);
                                sellectall.setChecked(true);
                            }
                            dialog.dismiss();
                            getEditAttendanceDate(lecture_edittext.getText().toString(), true);

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

    public void showDialog(final String lecture, String current_date, final String students_count) {
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

        for (EditAttendanceData attendanceData : arrayEditList) {

            if (attendanceData.isChecked()) {
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

                int connectStatus = connectionCheck.isConnected(mCxt);
                if (connectStatus != NetworkUtils.TYPE_NOT_CONNECTED) {
                    try {
                        getalldata();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    dialog.dismiss();
                } else {
                    Intent intent = new Intent(mCxt, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dialog.show();
    }

    public void getalldata() throws JSONException {

        JSONObject jsonobj = new JSONObject();
        JSONArray Json_Mtp = new JSONArray();

        String data = "", attened = "", result = "", attendence_status = "", attended_lecture = "";
        int mtp = 0;
        for (EditAttendanceData attendanceData : arrayEditList) {
            //this condition worked when user changed editext mannually
            if (attendanceData.getFilleditbox() == null) {

                //this condition worked when attended not changed
                if (attendanceData.getAttended().equals(attendanceData.getTotal_held())) {

                    // this condition worked when select default attended
                    if (attendanceData.getLecture().equals(attendanceData.getAttended())) {
                        attened = attendanceData.getLecture();
                    } else {
                        attened = attendanceData.getAttended();
                    }
                } else {
                    attened = attendanceData.getAttended();
                }
            } else {
                attened = attendanceData.getFilleditbox();
            }


            if (attendanceData.isChecked()) {
                attendence_status = "1";
            } else {
                attendence_status = "0";

            }
            try {
                JSONObject Mtp_Object = new JSONObject();
                Mtp_Object.put("status", attendence_status);
                Mtp_Object.put("total_held", lecture_edittext.getText().toString());
                Mtp_Object.put("attended", attened);
                Mtp_Object.put("attendance_id", attendanceData.getAttendance_id());
                Mtp_Object.put("student_id", attendanceData.getStudent_id());
                Mtp_Object.put("subject_id", attendanceData.getSubject_id());
                Mtp_Object.put("update_count", attendanceData.getUpdate_count());
                Json_Mtp.put(mtp, Mtp_Object);
                mtp++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            jsonobj.put("Updated_Student_attendence", Json_Mtp);
            jsonobj.put("teacher_id", teacherId);
            JSONObject parent_object = new JSONObject();
            parent_object.put("result", jsonobj);
            Log.v("Json_response", parent_object.toString());

            data = parent_object.toString().replace("null", "");
            result = Constants.sendByPOSTJson(Variables.main_url + "update_attendance.php?", data);
            Log.v("Sync_post_url", result);
            JSONObject json = new JSONObject(result);
            String r = json.getString("response");
            if (r.equals("Y")) {
                Constants.customToast(mCxt, "Update Successfully", 0);
                Intent intent = new Intent(mCxt, TakeAttendanceList.class);
                startActivity(intent);
                overridePendingTransition(
                        R.anim.animation_enter_from_right,
                        R.anim.animation_leave_out_to_left);
            } else {
                Constants.customToast(mCxt, "Something went wrong", 1);
            }
            WriteDataFille.writeData("Response: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(mCxt, EditAttendanceActivity.class);
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
            Intent intent = new Intent(AttendanceEditActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}

