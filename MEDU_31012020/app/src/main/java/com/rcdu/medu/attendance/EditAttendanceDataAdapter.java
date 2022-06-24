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
import com.rcdu.medu.common.Constants;
import com.rcdu.medu.modelclass.EditAttendanceData;


import java.util.ArrayList;

public class EditAttendanceDataAdapter extends RecyclerView.Adapter<EditAttendanceDataAdapter.ViewHolder> {

    private Context mCxt;
    private ArrayList<EditAttendanceData> arrayList;
    int present_count = 0;
    int absent_count = 0;

    public EditAttendanceDataAdapter(Context mCxt, ArrayList<EditAttendanceData> arrayList) {
        this.mCxt = mCxt;
        this.arrayList = arrayList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public EditAttendanceDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_attendance_list_item, parent, false);
        EditAttendanceDataAdapter.ViewHolder myViewHolder = new EditAttendanceDataAdapter.ViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final EditAttendanceDataAdapter.ViewHolder holder, int position) {

        final EditAttendanceData model = arrayList.get(position);

        holder.serialNo.setText("" + (position + 1));
        holder.rollNo.setText(model.getCollege_roll());
        holder.studentName.setText(model.getStudent_name());

        if (model.getLecture().equals("") || model.getLecture().equals("0")) {
            holder.attendance_edit.setText(model.getLecture());


        } else if (!model.getLecture().equals("") || !model.getLecture().equals("0")) {
            holder.attendance_edit.setText(model.getLecture());
            if (Integer.parseInt(model.getLecture()) < Integer.parseInt(model.getTotal_held())) {
                Constants.customToast(mCxt, "Invalid Lecture", 1);
            } else {
                int updatecount = Integer.parseInt(model.getLecture()) - Integer.parseInt(model.getTotal_held());
                int number = Integer.parseInt(model.getAttended()) + updatecount;
                holder.attendance_edit.setText(String.valueOf(number));
                model.setAttended(String.valueOf(number));
                model.setChecked(true);
                if (!model.getAttended().equals("0")) {
                    holder.attendance_check.setChecked(true);
                    model.setAttended(model.getAttended());
                } else {
                    holder.attendance_check.setChecked(false);
                }
            }
        }

        holder.attendance_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    model.setChecked(true);
                    holder.attendance_edit.setText(model.getTotal_held());
                } else {
                    model.setChecked(false);
                    holder.attendance_edit.setText("0");
                }
            }
        });

        holder.attendance_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.setFilleditbox(holder.attendance_edit.getText().toString());
                if (!holder.attendance_edit.getText().toString().equals("0")) {
                    holder.attendance_check.setChecked(true);
                    model.setChecked(true);

                } else if (holder.attendance_edit.getText().toString().equals("0")) {
                    holder.attendance_check.setChecked(false);
                    model.setChecked(false);
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