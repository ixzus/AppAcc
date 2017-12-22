package com.eeepay.aweb;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by huan on 2017/12/21.
 */

public class XWebViewPreLoadService extends IntentService {
    private static final String TAG = "XWebViewPreLoadService";

    public XWebViewPreLoadService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //在这里添加我们要执行的代码，Intent中可以保存我们所需的数据，
        //每一次通过Intent发送的命令将被顺序执行
        initX5();
    }

    /**
     * 初始化X5内核
     */
    private void initX5() {

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };

        QbSdk.initX5Environment(getApplicationContext(), cb);

//        if (!QbSdk.isTbsCoreInited()) {
//            QbSdk.preInit(getApplicationContext(), cb);
//        }
    }

}