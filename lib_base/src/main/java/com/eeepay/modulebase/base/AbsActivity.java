package com.eeepay.modulebase.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eeepay.modulebase.R;
import com.eeepay.modulebase.event.EventBusUtil;
import com.eeepay.modulebase.event.MessageEvent;
import com.eeepay.modulebase.net.RxManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by ixzus on 2017/11/29.
 */

public abstract class AbsActivity extends RxAppCompatActivity {
    protected Context mContext = this;
    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG = getPackageName() + "." + getClass().getSimpleName();
        ActivityManager.getInstance().addActivity(this);
        if (isUseEventBus()) {
            EventBusUtil.register(this);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxManager.getInstance().clear(TAG);
        ActivityManager.getInstance().removeActivity(this);
        if (isUseEventBus()) {
            EventBusUtil.unregister(this);
        }
    }

    protected boolean isUseEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    protected void onMsgEvent(MessageEvent messageEvent) {
        if (null != messageEvent) {
            onMessageEvent(messageEvent);
        }
    }

    protected void onMessageEvent(MessageEvent messageEvent) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    protected void onMsgStickyEvent(MessageEvent messageEvent) {
        if (null != messageEvent) {
            onMessageStickyEvent(messageEvent);
        }
    }

    protected void onMessageStickyEvent(MessageEvent messageEvent) {

    }

    protected abstract
    @LayoutRes
    int initLayout();

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected void initToolBar(boolean isBack, String title, String subTitle) {
        if (null != getToolBar()) {
            setSupportActionBar(getToolBar());
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (isBack) {
                getToolBar().setNavigationIcon(R.mipmap.base_ic_back);
                getToolBar().setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                });
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
            if (null != getToolBarTitle()) {
                if (TextUtils.isEmpty(title)) {
                    getToolBarTitle().setText("");
                } else {
                    getToolBarTitle().setText(title);
                }
            }
            if (null != getToolBarSubTitle()) {
                if (TextUtils.isEmpty(subTitle)) {
                    getToolBarSubTitle().setText("");
                } else {
                    getToolBarSubTitle().setText(subTitle);
                }
            }
        }
    }

    protected void initToolBar(boolean isBack, String title, String subTitle, boolean isIc) {
        if (null != getToolBar()) {
            setSupportActionBar(getToolBar());
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (isBack) {
                getToolBar().setNavigationIcon(R.mipmap.base_ic_back);
                getToolBar().setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                });
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
            if (null != getToolBarTitle()) {
                if (TextUtils.isEmpty(title)) {
                    getToolBarTitle().setText("");
                } else {
                    getToolBarTitle().setText(title);
                }
            }
            if (null != getToolBarSubTitle()) {
                if (TextUtils.isEmpty(subTitle)) {
                    getToolBarSubTitle().setText("");
                } else {
                    getToolBarSubTitle().setText(subTitle);
                }
            }
            if (isIc) {
                getToolBarRightDrawable().setVisibility(View.VISIBLE);
            } else {
                getToolBarRightDrawable().setVisibility(View.GONE);
            }
        }
    }

    private Toolbar getToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    private TextView getToolBarTitle() {
        return (TextView) findViewById(R.id.toolbar_title);
    }

    private ImageView getToolBarRightDrawable() {
        return (ImageView) findViewById(R.id.toolbar_ic);
    }

    private TextView getToolBarSubTitle() {
        return (TextView) findViewById(R.id.toolbar_subtitle);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }

    /**
     * 添加fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragment(BaseFragment fragment, @IdRes int frameId) {
        checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .add(frameId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();

    }


    /**
     * 替换fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void replaceFragment(BaseFragment fragment, @IdRes int frameId) {
        checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(frameId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();

    }


    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    protected void hideFragment(BaseFragment fragment) {
        checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .hide(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 显示fragment
     *
     * @param fragment
     */
    protected void showFragment(BaseFragment fragment) {
        checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .show(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 移除fragment
     *
     * @param fragment
     */
    protected void removeFragment(BaseFragment fragment) {
        checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 弹出栈顶部的Fragment
     */
    protected void popFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    public <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }
}
