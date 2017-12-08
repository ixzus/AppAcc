package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(100);
        canvas.drawPoint(canvas.getWidth()/4, canvas.getHeight()/4, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(canvas.getWidth()/4*3, canvas.getHeight()/4, paint);

//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawPoint(canvas.getWidth()/2, canvas.getHeight()/4, paint);

//        paint.reset();
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setStrokeWidth(100);
//        paint.setAntiAlias(true);
//        float[] points = {100,600,400,600,700,600};
//        canvas.drawPoints(points, paint);
    }
}
