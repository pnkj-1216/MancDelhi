package com.rcdu.medu.modelclass;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attendance implements Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("total_attended")
    @Expose
    private String totalAttended;
    @SerializedName("total_held")
    @Expose
    private String totalHeld;
    public final static Parcelable.Creator<Attendance> CREATOR = new Creator<Attendance>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Attendance createFromParcel(Parcel in) {
            return new Attendance(in);
        }

        public Attendance[] newArray(int size) {
            return (new Attendance[size]);
        }

    }
            ;

    protected Attendance(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAttended = ((String) in.readValue((String.class.getClassLoader())));
        this.totalHeld = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attendance() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalAttended() {
        return totalAttended;
    }

    public void setTotalAttended(String totalAttended) {
        this.totalAttended = totalAttended;
    }

    public String getTotalHeld() {
        return totalHeld;
    }

    public void setTotalHeld(String totalHeld) {
        this.totalHeld = totalHeld;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(totalAttended);
        dest.writeValue(totalHeld);
    }

    public int describeContents() {
        return 0;
    }

}