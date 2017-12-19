package com.eeepay.awdiget.demo;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huan on 2017/12/19.
 */

public class CustomView extends View {

    protected Context mContext;
    protected int mWidth;
    protected int mHeight;
    protected Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    protected TextPaint mTextPaint = new TextPaint();

    public CustomView(Context context) {
//        super(context);
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }
}
