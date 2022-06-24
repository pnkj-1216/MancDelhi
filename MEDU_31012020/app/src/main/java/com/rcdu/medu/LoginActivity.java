package com.rcdu.medu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.rcdu.medu.common.Constants;
import com.rcdu.medu.common.Variables;
import com.rcdu.medu.connectivity.ConnectionCheck;
import com.rcdu.medu.connectivity.NetworkUtils;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;
import com.rcdu.medu.rest.ApiClient;
import com.rcdu.medu.rest.ApiInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText loginUserName, loginUserPassword;
    private Button loginButton;
    private Spinner loginSpinner;
    private String[] strArray = {"Teacher", "Student", "Admin"};
    private DataBaseManipulate dm;
    private Context context;
    ConnectionCheck connectionCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parameters();
        setSpinnerItem();
    }

    private void parameters() {
        context = LoginActivity.this;
        dm = new DataBaseManipulate(context);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login Page");
        setSupportActionBar(toolbar);
        connectionCheck = new ConnectionCheck();
        loginButton = findViewById(R.id.loginButton);
        loginUserName = findViewById(R.id.loginUserName);
        loginUserPassword = findViewById(R.id.loginUserPassword);
        loginSpinner = findViewById(R.id.loginSpinner);
        loginButton.setOnClickListener(this);

        overridePendingTransition(
                R.anim.animation_enter_from_right,
                R.anim.animation_leave_out_to_left);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.loginButton) {
            int connectStatus = connectionCheck.isConnected(this);
            if (connectStatus != NetworkUtils.TYPE_NOT_CONNECTED) {
                if (loginUserName.getText().toString().isEmpty() ||
                        loginUserPassword.getText().toString().isEmpty()) {
                    Constants.customToast(context, "User Name and Password must be filled", 1);
                } else {
                    String user_name = loginUserName.getText().toString();
                    String password = loginUserPassword.getText().toString();
                    logindata(user_name, password);
                }
            } else {
                Constants.showNetworkAlert(context);

            }
        }
    }

    private void setSpinnerItem() {

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginSpinner.setAdapter(aa);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    public void logindata(String user_name, String password) {
        try {
            ApiInterface apiInterface;
            final ProgressDialog dialog;
            int version_code = Variables.getApplicationVersionCode(context);
            String version_name = Variables.getApplicationVersionName(context);
            dialog = new ProgressDialog(context, R.style.DialogSlideAnim);
            dialog.setMessage("Please wait,loading data");
            dialog.setCancelable(false);
            dialog.show();
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<JsonObject> call = apiInterface.getLogin(user_name, password, "2");
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    try {
                        int code = response.code();
                        if (code == 200) {
                            JsonObject mResponseBody1 = response.body();
                            JsonArray mResponseBody = mResponseBody1.getAsJsonArray("result");
                            String responseStatus = mResponseBody.get(0).getAsJsonObject().get("response").getAsString();

                            if (responseStatus.equals("LOGIN_TRUE")) {
                                JsonArray user_details = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("person_details");

                                if (user_details != null) {
                                    String role_id = user_details.get(0).getAsJsonObject().get("role_id").getAsString();
                                    String title = user_details.get(0).getAsJsonObject().get("title").getAsString();
                                    String rolename = user_details.get(0).getAsJsonObject().get("rolename").getAsString();
                                    String person_id = user_details.get(0).getAsJsonObject().get("person_id").getAsString();
                                    String person_fullname = user_details.get(0).getAsJsonObject().get("person_fullname").getAsString();
                                    String marital_status = user_details.get(0).getAsJsonObject().get("marital_status").getAsString();
                                    String dob = user_details.get(0).getAsJsonObject().get("dob").getAsString();
                                    String gender = user_details.get(0).getAsJsonObject().get("gender").getAsString();
                                    String doj = user_details.get(0).getAsJsonObject().get("doj").getAsString();
                                    String email = user_details.get(0).getAsJsonObject().get("email").getAsString();
                                    String mobile = user_details.get(0).getAsJsonObject().get("mobile").getAsString();
                                    String emp_code = user_details.get(0).getAsJsonObject().get("emp_code").getAsString();
                                    String dept = user_details.get(0).getAsJsonObject().get("dept").getAsString();
                                    Constants.setPrefrence(context, "User_id", person_id);
                                    Constants.setPrefrence(context, "designation", rolename);


                                    ContentValues cv = new ContentValues();
                                    cv.put("role_id", role_id);
                                    cv.put("title", title);
                                    cv.put("rolename", rolename);
                                    cv.put("person_id", person_id);
                                    cv.put("person_fullname", person_fullname);
                                    cv.put("marital_status", marital_status);
                                    cv.put("dob", dob);
                                    cv.put("email", email);
                                    cv.put("mobile", mobile);
                                    cv.put("gender", gender);
                                    cv.put("doj", doj);
                                    cv.put("emp_code", emp_code);
                                    cv.put("dept", dept);

                                    long a = dm.InsertData(DataBaseManipulate.LOGIN_CONSTANT_DELETE, cv, "id");

                                }


                                JsonArray subject_details_array = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("subject_details");

                                dm.deletetable(DataBaseManipulate.LOGIN_COURSE_TABLE);


                                for (int subject_details = 0; subject_details < subject_details_array.size(); subject_details++) {

                                    JsonArray courseArray = subject_details_array.get(subject_details).getAsJsonObject().getAsJsonArray("course");
                                    for (int course = 0; course < courseArray.size(); course++) {

                                        String course_id = courseArray.get(course).getAsJsonObject().get("id").getAsString();
                                        String course_name = courseArray.get(course).getAsJsonObject().get("name").getAsString();

                                        ContentValues cv = new ContentValues();
                                        cv.clear();

                                        cv.put("id", course_id);
                                        cv.put("name", course_name);

                                        dm.InsertData(DataBaseManipulate.LOGIN_COURSE_TABLE, cv,
                                                "t_id");
                                    }
                                    dm.deletetable(DataBaseManipulate.LOGIN_SUBJECT_TABLE);
                                    JsonArray subjectArray = subject_details_array.get(subject_details).getAsJsonObject().getAsJsonArray("subject");
                                    for (int course = 0; course < subjectArray.size(); course++) {

                                        String id = subjectArray.get(course).getAsJsonObject().get("id").getAsString();
                                        String name = subjectArray.get(course).getAsJsonObject().get("name").getAsString();
                                        String paper_type_id = subjectArray.get(course).getAsJsonObject().get("paper_type_id").getAsString();
                                        String semester_id = subjectArray.get(course).getAsJsonObject().get("semester_id").getAsString();
                                        String Test = subjectArray.get(course).getAsJsonObject().get("Test").getAsString();
                                        String Assignment = subjectArray.get(course).getAsJsonObject().get("Assignment").getAsString();
                                        String Presentation = subjectArray.get(course).getAsJsonObject().get("Presentation").getAsString();
                                        String Lab = subjectArray.get(course).getAsJsonObject().get("Lab").getAsString();

                                        ContentValues cv = new ContentValues();
                                        cv.clear();

                                        cv.put("id", id);
                                        cv.put("name", name);
                                        cv.put("paper_type_id", paper_type_id);
                                        cv.put("semester_id", semester_id);
                                        cv.put("Test", Test);
                                        cv.put("Assignment", Assignment);
                                        cv.put("Presentation", Presentation);
                                        cv.put("Lab", Lab);

                                        dm.InsertData(DataBaseManipulate.LOGIN_SUBJECT_TABLE, cv,
                                                "t_id");
                                    }

                                    dm.deletetable(DataBaseManipulate.LOGIN_SEMESTER_TABLE);
                                    JsonArray semesterArray = subject_details_array.get(subject_details).getAsJsonObject().getAsJsonArray("semester");
                                    for (int course = 0; course < semesterArray.size(); course++) {

                                        String id = semesterArray.get(course).getAsJsonObject().get("id").getAsString();
                                        String name = semesterArray.get(course).getAsJsonObject().get("name").getAsString();
                                        String subject_id = semesterArray.get(course).getAsJsonObject().get("subject_id").getAsString();


                                        ContentValues cv = new ContentValues();
                                        cv.clear();

                                        cv.put("id", id);
                                        cv.put("name", name);
                                        cv.put("subject_id", subject_id);

                                        dm.InsertData(DataBaseManipulate.LOGIN_SEMESTER_TABLE, cv,
                                                "t_id");
                                    }

                                    dm.deletetable(DataBaseManipulate.LOGIN_SECTION_TABLE);
                                    JsonArray sectionArray = subject_details_array.get(subject_details).getAsJsonObject().getAsJsonArray("section");
                                    for (int course = 0; course < sectionArray.size(); course++) {

                                        String id = sectionArray.get(course).getAsJsonObject().get("id").getAsString();
                                        String name = sectionArray.get(course).getAsJsonObject().get("name").getAsString();
                                        String semester_id = sectionArray.get(course).getAsJsonObject().get("semester_id").getAsString();
                                        String section_type = sectionArray.get(course).getAsJsonObject().get("section_type").getAsString();


                                        ContentValues cv = new ContentValues();
                                        cv.clear();

                                        cv.put("id", id);
                                        cv.put("name", name);
                                        cv.put("semester_id", semester_id);
                                        cv.put("section_type", section_type);

                                        dm.InsertData(DataBaseManipulate.LOGIN_SECTION_TABLE, cv,
                                                "t_id");
                                    }
                                }


                                JsonArray class_typeArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("class_type");

                                dm.deletetable(DataBaseManipulate.LOGIN_CLASS_TYPE_TABLE);
                                for (int class_type = 0; class_type < class_typeArray.size(); class_type++) {

                                    String course_id = class_typeArray.get(class_type).getAsJsonObject().get("id").getAsString();
                                    String course_name = class_typeArray.get(class_type).getAsJsonObject().get("name").getAsString();
                                    String sequence_id = class_typeArray.get(class_type).getAsJsonObject().get("sequence_id").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", course_id);
                                    cv.put("name", course_name);
                                    cv.put("sequence_id", sequence_id);

                                    dm.InsertData(DataBaseManipulate.LOGIN_CLASS_TYPE_TABLE, cv,
                                            "t_id");
                                }


                                JsonArray student_detailsArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("student_details");

                                dm.deletetable(DataBaseManipulate.LOGIN_CLASS_STUDENTS_DETAILS_TABLE);


                                for (int student_details = 0; student_details < student_detailsArray.size(); student_details++) {

                                    String paper_type_id = student_detailsArray.get(student_details).getAsJsonObject().get("paper_type_id").getAsString();
                                    String course_id = student_detailsArray.get(student_details).getAsJsonObject().get("course_id").getAsString();
                                    String subject_id = student_detailsArray.get(student_details).getAsJsonObject().get("subject_id").getAsString();
                                    String semester_id = student_detailsArray.get(student_details).getAsJsonObject().get("semester_id").getAsString();
                                    String section_id = student_detailsArray.get(student_details).getAsJsonObject().get("section_id").getAsString();
                                    String student_id = student_detailsArray.get(student_details).getAsJsonObject().get("student_id").getAsString();
                                    String student_name = student_detailsArray.get(student_details).getAsJsonObject().get("student_name").getAsString();
                                    String college_roll = student_detailsArray.get(student_details).getAsJsonObject().get("college_roll").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("paper_type_id", paper_type_id);
                                    cv.put("course_id", course_id);
                                    cv.put("subject_id", subject_id);
                                    cv.put("semester_id", semester_id);
                                    cv.put("section_id", section_id);
                                    cv.put("student_id", student_id);
                                    cv.put("student_name", student_name);
                                    cv.put("college_roll", college_roll);

                                    dm.InsertData(DataBaseManipulate.LOGIN_CLASS_STUDENTS_DETAILS_TABLE, cv,
                                            "t_id");
                                }

                                JsonArray leave_typeArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("leave_type");

                                dm.deletetable(DataBaseManipulate.LOGIN_LEAVE_TYPE_TABLE);


                                for (int leave_type = 0; leave_type < leave_typeArray.size(); leave_type++) {

                                    String id = leave_typeArray.get(leave_type).getAsJsonObject().get("id").getAsString();
                                    String name = leave_typeArray.get(leave_type).getAsJsonObject().get("name").getAsString();
                                    String short_name = leave_typeArray.get(leave_type).getAsJsonObject().get("short_name").getAsString();
                                    String total_leave = leave_typeArray.get(leave_type).getAsJsonObject().get("total_leave").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);
                                    cv.put("short_name", short_name);
                                    cv.put("total_leave", total_leave);


                                    dm.InsertData(DataBaseManipulate.LOGIN_LEAVE_TYPE_TABLE, cv,
                                            "t_id");
                                }

                                JsonArray assessment_typesArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("assessment_types");

                                dm.deletetable(DataBaseManipulate.LOGIN_ASSESSMENT_TYPE);


                                for (int assessment_types = 0; assessment_types < assessment_typesArray.size(); assessment_types++) {

                                    String id = assessment_typesArray.get(assessment_types).getAsJsonObject().get("id").getAsString();
                                    String name = assessment_typesArray.get(assessment_types).getAsJsonObject().get("assessment_title").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);


                                    dm.InsertData(DataBaseManipulate.LOGIN_ASSESSMENT_TYPE, cv,
                                            "t_id");
                                }

                                JsonArray paper_typesArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("paper_types");

                                dm.deletetable(DataBaseManipulate.LOGIN_PAPER_TYPE);
                                for (int paper_types = 0; paper_types < paper_typesArray.size(); paper_types++) {

                                    String id = paper_typesArray.get(paper_types).getAsJsonObject().get("id").getAsString();
                                    String name = paper_typesArray.get(paper_types).getAsJsonObject().get("name").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);


                                    dm.InsertData(DataBaseManipulate.LOGIN_PAPER_TYPE, cv,
                                            "t_id");
                                }

                                JsonArray priority_masterArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("priority_master");

                                dm.deletetable(DataBaseManipulate.LOGIN_PRIORITY_MASTER_TYPE);


                                for (int priority_master = 0; priority_master < priority_masterArray.size(); priority_master++) {

                                    String id = priority_masterArray.get(priority_master).getAsJsonObject().get("id").getAsString();
                                    String name = priority_masterArray.get(priority_master).getAsJsonObject().get("name").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);


                                    dm.InsertData(DataBaseManipulate.LOGIN_PRIORITY_MASTER_TYPE, cv,
                                            "t_id");
                                }

                                JsonArray department_masterArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("department_master");

                                dm.deletetable(DataBaseManipulate.LOGIN_DEPARTMENT_MASTER_TYPE);


                                for (int department_master = 0; department_master < department_masterArray.size(); department_master++) {

                                    String id = department_masterArray.get(department_master).getAsJsonObject().get("id").getAsString();
                                    String name = department_masterArray.get(department_master).getAsJsonObject().get("name").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);


                                    dm.InsertData(DataBaseManipulate.LOGIN_DEPARTMENT_MASTER_TYPE, cv,
                                            "t_id");
                                }

                                JsonArray time_periodArray = mResponseBody.get(0).getAsJsonObject().getAsJsonArray("time_period");

                                dm.deletetable(DataBaseManipulate.LOGIN_TIME_PERIOD_TYPE);


                                for (int time_period = 0; time_period < time_periodArray.size(); time_period++) {

                                    String id = time_periodArray.get(time_period).getAsJsonObject().get("id").getAsString();
                                    String name = time_periodArray.get(time_period).getAsJsonObject().get("name").getAsString();
                                    String start_time = time_periodArray.get(time_period).getAsJsonObject().get("start_time").getAsString();
                                    String end_time = time_periodArray.get(time_period).getAsJsonObject().get("end_time").getAsString();

                                    ContentValues cv = new ContentValues();
                                    cv.clear();

                                    cv.put("id", id);
                                    cv.put("name", name);
                                    cv.put("start_time", start_time);
                                    cv.put("end_time", end_time);


                                    dm.InsertData(DataBaseManipulate.LOGIN_TIME_PERIOD_TYPE, cv,
                                            "t_id");
                                }
                                dialog.dismiss();

                                Intent intent = new Intent(context, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                                Constants.customToast(context, "Successfully Login", 0);

                                overridePendingTransition(
                                        R.anim.animation_enter_from_right,
                                        R.anim.animation_leave_out_to_left);

                            } else {
                                dialog.dismiss();
                                Constants.customToast(context, "Please enter correct Id and Password", 1);
                            }
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
        finish();
    }
}

