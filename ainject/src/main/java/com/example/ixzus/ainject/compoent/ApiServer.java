package com.example.ixzus.ainject.compoent;

import android.util.Log;

import javax.inject.Inject;


/**
 * Created by huan on 2017/11/3.
 */

public class ApiServer {
    private static final String TAG = "ApiServer";

//    @Inject
    public ApiServer() {
        Log.e(TAG, "ApiServer()");
    }

    public void register() {
        Log.e(TAG, "register()");
    }
}
