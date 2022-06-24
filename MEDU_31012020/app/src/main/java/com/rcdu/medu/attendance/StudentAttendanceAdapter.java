package com.rcdu.medu.attendance;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.R;
import com.rcdu.medu.modelclass.StudentAttendanceModel;

import java.util.ArrayList;

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.ViewHolder> {

    private Context mCxt;
    private ArrayList<StudentAttendanceModel> arrayList;

    public StudentAttendanceAdapter(Context mCxt, ArrayList<StudentAttendanceModel> arrayList) {

        this.mCxt = mCxt;
        this.arrayList = arrayList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public StudentAttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_attendance_adapter, parent, false);
        StudentAttendanceAdapter.ViewHolder myViewHolder = new StudentAttendanceAdapter.ViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentAttendanceAdapter.ViewHolder holder, int position) {

        final StudentAttendanceModel model = arrayList.get(position);

        holder.serialNo.setText("" + (position + 1));
        holder.rollNo.setText(model.getCollege_roll());
        holder.studentName.setText(model.getStudent_name());


        if (model.isCheck()) {
            holder.attendance_check.setChecked(true);
            holder.attendance_edit.setText(model.getLecture());
        } else {
            holder.attendance_check.setChecked(false);
            holder.attendance_edit.setText("0");
        }
        holder.attendance_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /// this condition check when user select all check unchecked. and select mannualy
                if (!model.isCheck()) {
                    if (isChecked) {
                        model.setCheck(true);
                        holder.attendance_edit.setText(model.getLecture());
                        model.setLecture(holder.attendance_edit.getText().toString());
                    } else {
                        holder.attendance_edit.setText("0");
                        model.setCheck(false);
                    }
                } else {
                    if (isChecked) {
                        holder.attendance_edit.setText(model.getLecture());
                        model.setCheck(true);
                    } else {
                        holder.attendance_edit.setText("0");
                        model.setCheck(false);
                    }
                }
            }
        });

        holder.attendance_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // this condition worked when user click on back in edittext
                model.setFilleditbox(holder.attendance_edit.getText().toString());
                if (holder.attendance_edit.getText().toString().equals("0")) {
                    holder.attendance_check.setChecked(false);
                } else {
                    holder.attendance_check.setChecked(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView serialNo, rollNo, studentName;
        AppCompatCheckBox attendance_check;
        AppCompatEditText attendance_edit;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            serialNo = itemView.findViewById(R.id.serialNo);
            rollNo = itemView.findViewById(R.id.rollNo);
            studentName = itemView.findViewById(R.id.studentName);
            attendance_edit = itemView.findViewById(R.id.attendance_edit);
            attendance_check = itemView.findViewById(R.id.attendance_check);
        }
    }

}
