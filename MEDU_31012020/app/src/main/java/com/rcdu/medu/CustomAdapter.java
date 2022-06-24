package com.rcdu.medu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rcdu.medu.attendance.TakeAttendanceList;

import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    ArrayList<DataSet> name;

    public CustomAdapter(Context context, ArrayList<DataSet> name) {
        this.context = context;
        this.name = name;
     }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridelayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, final int position) {

     final   DataSet dataSet=   name.get(position);
        holder.textView.setText(dataSet.getName());
        holder.imageView.setImageResource(dataSet.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataSet.getName().equals("Attendance")){
                    Intent takeattendancelist= new Intent(context, TakeAttendanceList.class);
                    takeattendancelist.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(takeattendancelist);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}


