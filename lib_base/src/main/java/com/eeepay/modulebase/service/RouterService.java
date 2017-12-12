package com.eeepay.modulebase.service;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by huan on 2017/11/30.
 */

public class RouterService {
    public static String getValue(String key){
        ITestService testService = ARouter.getInstance().navigation(ITestService.class);
        if(null!=testService){
            return testService.getValue(key);
        }
        return "";
    }

    // String value = RouterService.getValue("gogogo");
}
