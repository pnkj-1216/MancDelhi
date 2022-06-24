package com.rcdu.medu.rest;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("signin.php?")
    Call<JsonObject> getLogin(
                              @Query("uname") String user_id,
                              @Query("pass") String pass,
                              @Query("status") String v_code
                              );

    @GET("teacher_daily_datewise_attendance.php?")
    Call<JsonObject> getAttendanceDatewiseData(
            @Query("date") String date,
            @Query("teacher_id") String teacher_id,
            @Query("subject_id") String subject_id,
            @Query("semester_id") String semester_id,
            @Query("section_id") String section_id,
            @Query("class_type") String class_type);

    @GET("attendance_edit.php?")
    Call<JsonObject> getEditAttendanceData(
            @Query("date") String date,
            @Query("teacher_id") String teacher_id,
            @Query("subject_id") String subject_id,
            @Query("semester_id") String semester_id,
            @Query("section_id") String section_id,
            @Query("class_type") String class_type

    );
    @FormUrlEncoded
    @POST("update_attendance.php?")
    Call<JsonObject> getUpdateAttendance(@Field("result") String apidata);

    @FormUrlEncoded
    @POST("sync_post.php?")
    Call<JsonObject> syncData(@Field("result") String apidata);

    @GET("eregister.php?")
    Call<JsonObject> getAttendanceMonthwiseData(
            @Query("month") String month,
            @Query("teacher_id") String teacher_id,
            @Query("subject_id") String subject_id,
            @Query("semester_id") String semester_id,
            @Query("section_id") String section_id,
            @Query("class_type") String class_type);







}




