package com.rcdu.medu.attendancereport;

public class AttendanceDateWiseReportModel {

    String student_name;
    String college_roll;
    String total_attended;
    String total_held;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCollege_roll() {
        return college_roll;
    }

    public void setCollege_roll(String college_roll) {
        this.college_roll = college_roll;
    }

    public String getTotal_attended() {
        return total_attended;
    }

    public void setTotal_attended(String total_attended) {
        this.total_attended = total_attended;
    }

    public String getTotal_held() {
        return total_held;
    }

    public void setTotal_held(String total_held) {
        this.total_held = total_held;
    }
}
