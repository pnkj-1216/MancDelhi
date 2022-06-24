package com.rcdu.medu.allSyncMethod;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.rcdu.medu.MainActivity;
import com.rcdu.medu.R;
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.common.Validation;
import com.rcdu.medu.databaseFiles.DataBaseManipulate;
import com.rcdu.medu.rest.ApiClient;
import com.rcdu.medu.rest.ApiInterface;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;


import retrofit2.Call;
import retrofit2.Callback;

public class GetSyncData {
    private DataBaseManipulate db;
    private static Context context;
    Cursor cursor;
    public JSONObject jsonobj;
    StringBuffer sb;
    JSONArray finalresult;
    private ApiInterface mApiService;

    public GetSyncData(Context context) {
        GetSyncData.context = context;
        db = new DataBaseManipulate(GetSyncData.context);
        jsonobj = new JSONObject();
        finalresult = new JSONArray();
        sb = new StringBuffer();
    }


    public void getSyncStudentAttendance() {
        try {
            JSONArray Json_Mtp = new JSONArray();
            int mtp = 0;
            cursor = db.getAllTakeStudentAttendance();
            int sec = cursor.getCount();
            if (sec != 0) {
                if (cursor.moveToFirst()) {
                    do {
                        String attendence_id = cursor.getString(cursor.getColumnIndex("attendence_id"));
                        String attendence_date = cursor.getString(cursor.getColumnIndex("attendence_date"));
                        String attendence_status = cursor.getString(cursor
                                .getColumnIndex("attendence_status"));
                        String attendence_total_held = cursor.getString(cursor.getColumnIndex("attendence_total_held"));
                        String semester_id = cursor.getString(cursor
                                .getColumnIndex("semester_id"));
                        String student_id = cursor.getString(cursor
                                .getColumnIndex("student_id"));
                        String lecture_attended = cursor.getString(cursor
                                .getColumnIndex("lecture_attended"));
                        String sub_id = cursor.getString(cursor
                                .getColumnIndex("sub_id"));
                        String section_id = cursor.getString(cursor
                                .getColumnIndex("section_id"));
                        String course_id = cursor.getString(cursor
                                .getColumnIndex("course_id"));
                        String attendence_time = cursor.getString(cursor
                                .getColumnIndex("attendence_time"));
                        String attendence_created_datetime = cursor.getString(cursor
                                .getColumnIndex("attendence_created_datetime"));
                        String class_type_id = cursor.getString(cursor
                                .getColumnIndex("class_type_id"));

                        JSONObject Mtp_Object = new JSONObject();
                        Mtp_Object.put("attendence_id", attendence_id);
                        Mtp_Object.put("attendence_date", attendence_date);
                        Mtp_Object.put("attendence_status", attendence_status);
                        Mtp_Object.put("attendence_total_held", attendence_total_held);
                        Mtp_Object.put("semester_id", semester_id);
                        Mtp_Object.put("student_id", student_id);

                        Mtp_Object.put("lecture_attended", lecture_attended);
                        Mtp_Object.put("sub_id", sub_id);
                        Mtp_Object.put("section_id", section_id);
                        Mtp_Object.put("course_id", course_id);
                        Mtp_Object.put("attendence_time", attendence_time);
                        Mtp_Object.put("attendence_created_datetime", attendence_created_datetime);
                        Mtp_Object.put("class_type_id", class_type_id);

                        Json_Mtp.put(mtp, Mtp_Object);
                        mtp++;

                    } while (cursor.moveToNext());
                }
            }

            jsonobj.put("Student_attendence", Json_Mtp);
            System.out.println("surveyFormDataJsonObject=====>>>" + jsonobj);
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void getDataSync() {
//        final ProgressDialog dialog;
//        dialog = new ProgressDialog(context);
//        dialog.setMessage(("Loading message"));
//        dialog.setCancelable(false);
//        dialog.show();
        String data = "";
        String teacherId = Constants.getPrefrence(context, "User_id");

        getSyncStudentAttendance();

        try {

            jsonobj.put("teacher_id", teacherId);
            JSONObject parent_object = new JSONObject();
            parent_object.put("result", jsonobj);
            Log.v("Json_response", parent_object.toString());
            data = parent_object.toString().replace("null", " ");

        } catch (Exception e) {
            e.printStackTrace();
        }

        mApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> mService = mApiService.syncData(data);
        mService.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                int code = response.code();
                if (code == 200) {
                    JsonObject mResponseBody = response.body();
                    if (mResponseBody != null) {
                       // dialog.dismiss();
                        String key = mResponseBody.getAsJsonObject().get("response").getAsString();
                        if (key.equals("Y")) {
                            ContentValues cv = new ContentValues();
                            cv.clear();
                            cv.put("delete_status", 1);
                            db.UpdateDataStatus(DataBaseManipulate.TAKE_STUDENT_ATTENDANCE, cv);

                            String date = Validation.getDate();
                            String time = Validation.getTime();

                            ContentValues contentValues = new ContentValues();
                            contentValues.put("date", date);
                            contentValues.put("time", time);

                            long last_sync = db.InsertData(DataBaseManipulate.lasttimesyncdateandtime, contentValues, "id");
                            if (last_sync > 0) {
                            }

                            Constants.customToast(context, Constants.MTP_SYNC_SUCCESS, 0);
                            Intent intent = new Intent(context, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(intent);
                            ((Activity) context).overridePendingTransition(R.anim.exit_animation_enter_from_right,
                                    R.anim.exit_animation_leave_to_right);
                            ((Activity) context).finish();

                        } else {
                          //  dialog.dismiss();
                            Constants.customToast(context, Constants.ERROR_RESPONSE, 1);
                        }
                    } else {
                       // dialog.dismiss();
                        Constants.customToast(context, Constants.NO_DATA_FOUND, 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Constants.customToast(context, Constants.ERROR_RESPONSE, 1);
                call.cancel();
               // dialog.dismiss();
            }
        });
    }


}