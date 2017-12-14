package com.eeepay.awdiget.hencoder.practice7;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class Sample01ArgbEvaluatorView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int color = 0xffff0000;

    public Sample01ArgbEvaluatorView(Context context) {
        super(context);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    public void setData(int startValue,int endValue){
        ObjectAnimator animator = ObjectAnimator.ofInt(this, "color", startValue, endValue);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                setData(0xffff0000, 0xff00ff00);
            }
        }, 300);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        paint.setColor(color);
        canvas.drawCircle(width / 2, height / 2, width / 6, paint);
    }
}
