package com.eeepay.modulebase.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eeepay.modulebase.R;
import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by huan on 2017/11/29.
 */

public abstract class BaseBindingActivity<T extends ViewDataBinding> extends AbsActivity {
    protected T binding;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, initLayout());
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

}
