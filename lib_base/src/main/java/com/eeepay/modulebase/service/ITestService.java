package com.eeepay.modulebase.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by huan on 2017/11/29.
 */

public interface ITestService extends IProvider {
    String getValue(String key);
}
