package com.rcdu.medu.attendancereport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.rcdu.medu.R;
import com.rcdu.medu.modelclass.Attendance;

import java.util.ArrayList;

public class StatusFragment extends Fragment {
    View view;
    RecyclerView recycler_workingstatus;
    private ArrayList<Attendance> projectModels;
    int category_id;
    public StatusFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_status_layout, container, false);
        recycler_workingstatus = view.findViewById(R.id.recycler_workingstatus);
        int position = FragmentPagerItem.getPosition(getArguments());
        projectModels = new ArrayList<>();
        projectModels = MonthWiseReportDatailsActivity.mAttendanceReportArrayList.get(position).getAttendance();
        setAdapter();
        return view;
    }
    public void setAdapter() {
        MonthlyAttenDataAdapter adapter = new MonthlyAttenDataAdapter(getActivity(), projectModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler_workingstatus.setLayoutManager(layoutManager);
        recycler_workingstatus.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
