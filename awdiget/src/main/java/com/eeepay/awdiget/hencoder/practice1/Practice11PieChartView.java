package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

public class Practice11PieChartView extends View {
    private static final String TAG = "Practice11PieChartView";
    private List<OSVersion> listData;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float maxVersion;
    private float totalVersion;
    private float initAngle = 0f;
    private int mWidth;
    private int mHeight;
    float startAngle;
    float sweptAngle;
    float halfAngle;
    float lineStartX;
    float lineStartY;
    float lineEndX;
    float lineEndY;
    float radius;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListData(List<OSVersion> listData) {
        this.listData = listData;
        for (OSVersion verison : listData) {
            totalVersion += verison.getNumber();
            maxVersion = Math.max(maxVersion, verison.getNumber());
        }
        invalidate();

    }
    public void setInitAngle(float initAngle) {
        this.initAngle = initAngle;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        Log.e("TAG", "onDraw: ");
        if (null == listData) {
            return;
        }
        startAngle = initAngle;
        String name = "饼图";
        paint.setColor(Color.WHITE);
        paint.setTextSize(28);
        canvas.drawText(name, (canvas.getWidth() - paint.measureText(name)) * 0.5f, canvas.getHeight() * 0.9f, paint);

        canvas.translate(canvas.getWidth() * 0.5f, canvas.getHeight() * 0.5f);
        paint.setStyle(Paint.Style.FILL);

        if (canvas.getWidth() > canvas.getHeight()) {
            radius = canvas.getHeight() / 4;
        } else {
            radius = canvas.getWidth() / 4;
        }

        RectF rectF = new RectF(-radius, -radius, radius, radius);
        for (OSVersion bean : listData) {
            paint.setColor(bean.getColor());
            sweptAngle = bean.getNumber() / totalVersion * 360;
            halfAngle = startAngle + sweptAngle * 0.5f;
            lineStartX = radius * (float) Math.cos(halfAngle / 180 * Math.PI);
            lineStartY = radius * (float) Math.sin(halfAngle / 180 * Math.PI);
            lineEndX = (radius + 50) * (float) Math.cos(halfAngle / 180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(halfAngle / 180 * Math.PI);

            if (maxVersion == bean.getNumber()) {
                canvas.save();
                canvas.translate(0.1f * lineStartX, lineStartY * 0.1f);  // 移动画布的原点
                canvas.drawArc(rectF, startAngle, sweptAngle, true, paint);
            } else {
                canvas.drawArc(rectF, startAngle, sweptAngle - 2f, true, paint);
            }

            paint.setColor(Color.WHITE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (halfAngle > 90 && halfAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
                canvas.drawText(bean.getName(), lineEndX - 50 - 10 - paint.measureText(bean.getName()), lineEndY, paint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
                canvas.drawText(bean.getName(), lineEndX + 50 + 10, lineEndY, paint);
            }
            if (maxVersion == bean.getNumber()) {
                canvas.restore();
            }
            startAngle += sweptAngle;
        }

    }

}
