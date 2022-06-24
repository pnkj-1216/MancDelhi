package com.rcdu.medu.modelclass;

public class EditAttendanceData {
    String status;
    String update_count;
    String attendance_id;
    String total_held;
    String attended;
    String subject_id;
    String date;
    String college_roll;
    String student_id;
    String student_name;
    boolean isChecked;
    String filleditbox;
    String lecture;

    public EditAttendanceData(String status, String update_count, String attendance_id,
                              String total_held, String attended, String subject_id,
                              String date, String college_roll, String student_id,
                              String student_name, String lecture, boolean isChecked) {
        this.status = status;
        this.update_count = update_count;
        this.attendance_id = attendance_id;
        this.total_held = total_held;
        this.attended = attended;
        this.subject_id = subject_id;
        this.date = date;
        this.college_roll = college_roll;
        this.student_id = student_id;
        this.student_name = student_name;
        this.lecture = lecture;
        this.isChecked = isChecked;

    }

    public EditAttendanceData(){

    }

    public String getFilleditbox() {
        return filleditbox;
    }

    public void setFilleditbox(String filleditbox) {
        this.filleditbox = filleditbox;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdate_count() {
        return update_count;
    }

    public void setUpdate_count(String update_count) {
        this.update_count = update_count;
    }

    public String getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(String attendance_id) {
        this.attendance_id = attendance_id;
    }

    public String getTotal_held() {
        return total_held;
    }

    public void setTotal_held(String total_held) {
        this.total_held = total_held;
    }

    public String getAttended() {
        return attended;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCollege_roll() {
        return college_roll;
    }

    public void setCollege_roll(String college_roll) {
        this.college_roll = college_roll;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
