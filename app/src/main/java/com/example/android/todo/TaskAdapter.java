package com.example.android.todo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


/**
 * Created by agustin.madina on 05/02/2015.
 */
public class TaskAdapter extends ArrayAdapter<Task> {

    Context mContext;
    List<Task> mTaskList;

    public TaskAdapter(Context context, List<Task> tasks){
        super(context,R.layout.list_entry,tasks);
        mContext=context;
        mTaskList=tasks;


    }

    private void displayContentInRowView(int position, View rowView) {
        if (rowView != null) {
            TextView textTaskTitle = (TextView)rowView.findViewById(R.id.text_task_title);
            textTaskTitle.setText(mTaskList.get(position).getTitle());
            CheckBox checkTaskDone = (CheckBox)rowView.findViewById(R.id.checkbox_task);
            checkTaskDone.setChecked(mTaskList.get(position).getDone());
        }
    }
    private View reuseOrGenerateRowView(View convertView, ViewGroup parent) {
        View rowView;
        if (convertView != null) {
            rowView = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_entry, parent, false);
        }
        return rowView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = reuseOrGenerateRowView(convertView, parent);

        displayContentInRowView(position, rowView);

        return rowView;
    }



}
