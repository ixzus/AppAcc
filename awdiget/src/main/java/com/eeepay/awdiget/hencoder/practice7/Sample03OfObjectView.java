package com.eeepay.awdiget.hencoder.practice7;

import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.eeepay.awdiget.hencoder.UIUtils;

public class Sample03OfObjectView extends View {
    public static final float RADIUS = UIUtils.dpToPixel(20);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    PointF position = new PointF();

    public Sample03OfObjectView(Context context) {
        super(context);
    }

    public Sample03OfObjectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03OfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#009688"));
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF position) {
        if (position != null) {
            this.position.set(position);
            invalidate();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setData(int x1, int y1, int x2, int y2) {
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "position",
                new PointFEvaluator(), new PointF(x1, y1), new PointF(x2, y2));
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000);
        animator.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    setData(0, 0, 1, 1);
                }
            }
        }, 300);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float innerPaddingLeft = RADIUS * 1;
        float innterPaddingRight = RADIUS * 1;
        float innterPaddingTop = RADIUS * 1;
        float innterPaddingBottom = RADIUS * 3;
        float width = getWidth() - innerPaddingLeft - innterPaddingRight - RADIUS * 2;
        float height = getHeight() - innterPaddingTop - innterPaddingBottom - RADIUS * 2;

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innterPaddingTop + RADIUS + height * position.y, RADIUS, paint);
    }
}
