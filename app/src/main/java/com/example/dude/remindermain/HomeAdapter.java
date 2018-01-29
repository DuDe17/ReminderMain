package com.example.dude.remindermain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashukla on 1/29/2018.
 */

public class HomeAdapter extends ArrayAdapter<AddLogicUnit> {

    private ArrayList<AddLogicUnit> listArray;

    public HomeAdapter(Context context, int textViewResourceId, ArrayList<AddLogicUnit> listArrays) {
        super(context, textViewResourceId, listArrays);
        this.listArray = listArrays;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_home, null);
        }

        AddLogicUnit addLogicUnit = listArray.get(position);

        if(addLogicUnit != null) {

            TextView taskNameLabel = (TextView) v.findViewById(R.id.TaskNameLabel);
            TextView taskNameData = (TextView) v.findViewById(R.id.EditTaskName);
            TextView totalTimeLabel = (TextView) v.findViewById(R.id.TotalTimeLabel);
            TextView totalTimeEdit = (TextView) v.findViewById(R.id.totalTimeEdit);

            if(taskNameLabel != null) {
                taskNameLabel.setText("Task Name: ");
            }
            if(taskNameData != null) {
                taskNameData.setText(addLogicUnit.getTaskName());
            }
            if(totalTimeLabel != null) {
                totalTimeLabel.setText("Total Time: ");
            }
            if(totalTimeEdit != null) {
                totalTimeEdit.setText(addLogicUnit.getTotalTime());
            }

        }

        return v;
    }

}
