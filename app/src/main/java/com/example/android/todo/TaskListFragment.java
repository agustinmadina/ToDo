package com.example.android.todo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends ListFragment {

    private static final int REQUEST_CODE = 1;

    TaskAdapter mTaskAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false);

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_todo_fragment, menu);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            List<Task> entries = new ArrayList<>();
            mTaskAdapter = new TaskAdapter(getActivity(), entries);
            setListAdapter(mTaskAdapter);
        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();


        switch (menuId) {
            case R.id.add_todo_task:
                Intent i = new Intent(getActivity(), NewTaskActivity.class);
                startActivityForResult(i, REQUEST_CODE);
                return true;

            default: return super.onOptionsItemSelected(item);
        }

    }

    private void addTask(String title) {
        Task task = new Task(getActivity(), title);
        mTaskAdapter.add(task);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                addTask(data.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }
}
