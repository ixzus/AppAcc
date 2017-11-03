package com.example.ixzus.ainject.compoent.inject;

import android.content.Context;
import android.util.Log;

import com.example.ixzus.ainject.compoent.ApiServer;
import com.example.ixzus.ainject.compoent.UserManager;
import com.example.ixzus.ainject.compoent.UserStor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huan on 2017/11/3.
 */

@Module
public class UserModule {
    private static final String TAG = "UserModule";

    private Context mContext;

    public UserModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public ApiServer providApiServer() {
        Log.e(TAG, "providApiServer()");
        return new ApiServer();
    }

    @Provides
    public UserStor providUserStor(){
        Log.e(TAG, "providStor()");
        return new UserStor();
    }


    @Named("TypeA")
    @Provides
    public UserManager providUserManagerA(ApiServer apiServer) {
        Log.e(TAG, "providUserManager(ApiServer apiServer)");
        return new UserManager(apiServer);
    }

    @Named("TypeB")
    @Provides
    public UserManager providUserManagerB(UserStor userStor) {
        Log.e(TAG, "providUserManager(UserStor userStor)");
        return new UserManager(userStor);
    }

    @Named("TypeAll")
    @Provides
    public UserManager providUserManagerAll(ApiServer apiServer, UserStor userStor) {
        Log.e(TAG, "providUserManager(ApiServer apiServer, UserStor userStor)");
        return new UserManager(apiServer,userStor);
    }
}
