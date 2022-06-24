package com.rcdu.medu.modelclass;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student implements Parcelable
{

    @SerializedName("student_id")
    @Expose
    private String studentId;
    @SerializedName("student_name")
    @Expose
    private String studentName;
    @SerializedName("college_roll")
    @Expose
    private String collegeRoll;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("attendance")
    @Expose
    private ArrayList<Attendance> attendance = null;
    public final static Parcelable.Creator<Student> CREATOR = new Creator<Student>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return (new Student[size]);
        }

    }
            ;

    protected Student(Parcel in) {
        this.studentId = ((String) in.readValue((String.class.getClassLoader())));
        this.studentName = ((String) in.readValue((String.class.getClassLoader())));
        this.collegeRoll = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.attendance, (Attendance.class.getClassLoader()));
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollegeRoll() {
        return collegeRoll;
    }

    public void setCollegeRoll(String collegeRoll) {
        this.collegeRoll = collegeRoll;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(ArrayList<Attendance> attendance) {
        this.attendance = attendance;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(studentId);
        dest.writeValue(studentName);
        dest.writeValue(collegeRoll);
        dest.writeValue(date);
        dest.writeList(attendance);
    }

    public int describeContents() {
        return 0;
    }

}