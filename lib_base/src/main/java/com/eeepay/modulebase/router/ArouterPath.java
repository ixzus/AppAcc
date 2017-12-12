package com.eeepay.modulebase.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.eeepay.modulebase.R;

/**
 * Created by huan on 2017/11/29.
 */

public class ArouterPath {
    public static final String UserActivity = "/appuser/UserActivity";


    public static final String CreditCardActivity = "/appcard/CreditCardActivity";
    public static final String TestService = "/appuser/ITestService";


    public static void startUserActivity(String userId) {
        ARouter.getInstance()
                .build(ArouterPath.UserActivity)
                .withString("userId", userId)
                .withTransition(R.anim.activity_in_right, R.anim.activity_out_right)
                .navigation();
    }
}
