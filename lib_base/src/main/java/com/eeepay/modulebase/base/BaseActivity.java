package com.eeepay.modulebase.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.eeepay.modulebase.R;
import com.gyf.barlibrary.ImmersionBar;


/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 */

public abstract class BaseActivity extends AbsActivity {
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mImmersionBar = ImmersionBar.with(this);
        if (null != mImmersionBar) {
            mImmersionBar.fitsSystemWindows(true);
            mImmersionBar.statusBarColor(R.color.colorStatus);
            mImmersionBar.init();
        }
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mImmersionBar) {
            mImmersionBar.destroy();
        }
    }
    protected abstract
    @LayoutRes
    int initLayout();

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected abstract void initData();
}

