package com.eeepay.aweb;

import android.app.Application;
import android.content.Intent;

/**
 * Created by huan on 2017/12/21.
 */

public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        preInitX5Core();

    }

    /**
     * 初始化X5内核
     */
    private void preInitX5Core() {
        //预加载x5内核
        Intent intent = new Intent(this, XWebViewPreLoadService.class);
        startService(intent);
    }
}
