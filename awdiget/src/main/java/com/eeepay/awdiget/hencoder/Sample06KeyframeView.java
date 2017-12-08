package com.eeepay.awdiget.hencoder;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static com.eeepay.awdiget.hencoder.Utils.dpToPixel;

public class Sample06KeyframeView extends View {
    private static final String TAG = "Sample06KeyframeView";
    final float radius = dpToPixel(80);

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
        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }


    private void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setData(int start, int end){
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", start, end);
        animator.setDuration(1000);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: " );
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }
}