package com.rcdu.medu.modelclass;

public class StudentAttendanceModel   {

    String todaytarget ;
    String course_id ;
    String subject_id;
    String semester_id;
    String section_id;
    String student_id;
    String student_name;
    String college_roll ;
    public boolean isCheck;
    String filleditbox;
    String lecture;

    public StudentAttendanceModel(String todaytarget, String course_id, String subject_id,
                                  String semester_id, String section_id, String student_id,
                                  String student_name, String college_roll,String lecture,boolean isCheck) {
        this.todaytarget = todaytarget;
        this.course_id = course_id;
        this.subject_id = subject_id;
        this.semester_id = semester_id;
        this.section_id = section_id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.college_roll = college_roll;
        this.lecture=lecture;
        this.isCheck=isCheck;
    }





    public String getTodaytarget() {
        return todaytarget;
    }

    public void setTodaytarget(String todaytarget) {
        this.todaytarget = todaytarget;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
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

    public String getCollege_roll() {
        return college_roll;
    }

    public void setCollege_roll(String college_roll) {
        this.college_roll = college_roll;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
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
}
