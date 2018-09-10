package com.example.a23988.fragment;

import android.app.Application;

import utils.db.DBhelper;
import utils.http.okgo;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        okgo.init(this);
        DBhelper.init(this);
    }
}
