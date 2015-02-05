package com.example.android.todo;

import android.content.Context;

/**
 * Created by agustin.madina on 05/02/2015.
 */
public class Task {

    String mTitle;
    Boolean mDone;
    static Context mContext;

    public String getTitle() {
        return mTitle;
    }


    public Boolean getDone() {
        return mDone;
    }

    public Task (Context context, String title) {
        mContext = context;
        mTitle = title;
        mDone = false;
    }

}
