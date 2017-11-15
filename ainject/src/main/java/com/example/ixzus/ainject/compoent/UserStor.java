package com.example.ixzus.ainject.compoent;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by huan on 2017/11/3.
 */

public class UserStor {
    private static final String TAG = "UserStor";

    @Inject
    public UserStor() {
        Log.e(TAG, "UserStor()");
    }

    public void register() {
        Log.e(TAG, "register()");
    }
}
