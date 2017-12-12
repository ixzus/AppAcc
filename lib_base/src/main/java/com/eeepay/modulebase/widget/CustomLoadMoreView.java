package com.eeepay.modulebase.widget;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.eeepay.modulebase.R;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/14.
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.wd_view_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
