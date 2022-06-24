package com.rcdu.medu.attendancereport;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.R;
import com.rcdu.medu.attendance.AttendanceEditActivity;
import com.rcdu.medu.modelclass.Attendance;

import java.util.ArrayList;

public class MonthlyAttenDataAdapter extends RecyclerView.Adapter<MonthlyAttenDataAdapter.MyViewHolder> {
   ArrayList<Attendance> mAttendanceDataArrayList;
   Context mCxt;


    public MonthlyAttenDataAdapter(Context mCxt, ArrayList<Attendance> mAttendanceDataArrayList)
    {
        this.mAttendanceDataArrayList=mAttendanceDataArrayList;
        this.mCxt=mCxt;
    }
    public MonthlyAttenDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_monthly_data,parent,false);
        MonthlyAttenDataAdapter.MyViewHolder myViewHolder=new MonthlyAttenDataAdapter.MyViewHolder(itemview);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MonthlyAttenDataAdapter.MyViewHolder holder, final int position) {
        final Attendance attendance=mAttendanceDataArrayList.get(position);
        holder.date.setText(attendance.getDate());
        holder.delivered_tv.setText((attendance.getTotalHeld()));
        holder.attended_tv.setText(attendance.getTotalAttended());
    }

    @Override
    public int getItemCount() {
        return mAttendanceDataArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView attended_tv;
        TextView delivered_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            attended_tv=itemView.findViewById(R.id.attended_tv);
            delivered_tv=itemView.findViewById(R.id.delivered_tv);


        }
    }
}
