package com.rcdu.medu.attendancereport;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.R;
import com.rcdu.medu.modelclass.Student;

import java.util.ArrayList;

public class MonthWiseReportAdapter extends RecyclerView.Adapter <MonthWiseReportAdapter.MyViewHolder> {

    ArrayList<Student> mAttendanceReportArrayList;
    Context mCtx;
    private int resource;
    String user_id = "";

    public MonthWiseReportAdapter(Context mCtx, ArrayList<Student> mAttendanceReportArrayList ) {
        this.mAttendanceReportArrayList = mAttendanceReportArrayList;
        this.mCtx = mCtx;

    }

    @NonNull
    @Override
    public MonthWiseReportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.monthwise_report_list_item, viewGroup, false );
        MonthWiseReportAdapter.MyViewHolder myViewHolder = new MonthWiseReportAdapter.MyViewHolder( itemView );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MonthWiseReportAdapter.MyViewHolder myViewHolder,final int i) {

        final Student student = mAttendanceReportArrayList.get( i );
       // myViewHolder.date.setText( student.getDate());
        myViewHolder.student_name_tv.setText( student.getStudentName() );
        myViewHolder.student_roll.setText( student.getCollegeRoll() );


            myViewHolder.linrear_compact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(mCtx,MonthlyAttenDataActivity.class);
                    intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) mAttendanceReportArrayList.get(i).getAttendance());
                    mCtx.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mAttendanceReportArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView student_name_tv;
        TextView student_roll;
        //TextView date;
        LinearLayoutCompat linrear_compact;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );


            student_name_tv = itemView.findViewById( R.id.student_name_tv );
           // date = itemView.findViewById( R.id.date );
            student_roll=itemView.findViewById( R.id.student_roll);
            linrear_compact=itemView.findViewById(R.id.linrear_compact);

        }
    }


}