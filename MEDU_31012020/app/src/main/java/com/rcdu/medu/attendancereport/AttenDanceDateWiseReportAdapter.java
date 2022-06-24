package com.rcdu.medu.attendancereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.R;

import java.util.ArrayList;

public class AttenDanceDateWiseReportAdapter extends RecyclerView.Adapter <AttenDanceDateWiseReportAdapter.MyViewHolder> {

    ArrayList<AttendanceDateWiseReportModel> mAttendanceReportArrayList;
    Context mCtx;
    private int resource;
    String user_id = "";

    public AttenDanceDateWiseReportAdapter(Context mCtx, ArrayList <AttendanceDateWiseReportModel> mAttendanceReportArrayList ) {
        this.mAttendanceReportArrayList = mAttendanceReportArrayList;
        this.mCtx = mCtx;

    }

    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.attendance_report_list_item, viewGroup, false );
        MyViewHolder myViewHolder = new  MyViewHolder( itemView );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final AttendanceDateWiseReportModel attendanceDateWiseReportModel = mAttendanceReportArrayList.get( i );
        myViewHolder.student_name_tv.setText( attendanceDateWiseReportModel.getStudent_name()+
                "\n["+attendanceDateWiseReportModel.getCollege_roll()+"]");
        myViewHolder.attended_tv.setText( attendanceDateWiseReportModel.getTotal_attended() );
        myViewHolder.delivered_tv.setText( attendanceDateWiseReportModel.getTotal_held() );



    }

    @Override
    public int getItemCount() {
        return mAttendanceReportArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView student_name_tv;
        TextView attended_tv;
        TextView delivered_tv;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );


            student_name_tv = itemView.findViewById( R.id.student_name_tv );
            attended_tv = itemView.findViewById( R.id.attended_tv );
            delivered_tv=itemView.findViewById( R.id.delivered_tv);

        }
    }


}



