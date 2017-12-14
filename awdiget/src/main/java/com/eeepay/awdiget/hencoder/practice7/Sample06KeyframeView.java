package com.eeepay.awdiget.hencoder.practice7;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import com.eeepay.awdiget.hencoder.UIUtils;


public class Sample06KeyframeView extends View {
    final float radius = UIUtils.dpToPixel(80);

    float progress = 0;
    RectF arcRectF = new RectF();

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample06KeyframeView(Context context) {
        super(context);
    }

    public Sample06KeyframeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample06KeyframeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(UIUtils.dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setData() {
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0); // 开始：progress 为 0
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100); // 进行到一半是，progres 为 100
        Keyframe keyframe3 = Keyframe.ofFloat(1, 80); // 结束时倒回到 80
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(this, holder);
        animator.setDuration(2000);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                setData();
            }
        }, 300);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(UIUtils.dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }
}
