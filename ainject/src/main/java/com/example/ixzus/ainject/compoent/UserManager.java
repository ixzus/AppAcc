package com.example.ixzus.ainject.compoent;

import android.util.Log;

/**
 * Created by huan on 2017/11/3.
 */

public class UserManager {
    private static final String TAG = "UserManager";
    private ApiServer apiServer;
    private UserStor userStor;

    public UserManager(ApiServer apiServer) {
        Log.e(TAG, "UserManager(ApiServer apiServer)" );
        this.apiServer = apiServer;
    }

    public UserManager(UserStor userStor) {
        Log.e(TAG, "UserManager(ApiServer userStor)" );
        this.userStor = userStor;
    }

    public UserManager(ApiServer apiServer, UserStor userStor) {
        Log.e(TAG, "UserManager(ApiServer apiServer, UserStor userStor)" );
        this.apiServer = apiServer;
        this.userStor = userStor;
    }

    public void registerA() {
        Log.e(TAG, "registerA()");
        apiServer.register();
    }
    public void registerB() {
        Log.e(TAG, "registerB()");
        userStor.register();
    }

    public void registerAll() {
        Log.e(TAG, "registerAll()");
        apiServer.register();
        userStor.register();
    }
}
