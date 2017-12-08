package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path = new Path();

//        (1) 实心
//        RectF rect1 = new RectF(200, 200, 400, 400);
//        RectF rect2 = new RectF(400, 200, 600, 400);
//        path.addArc(rect1, -225, 225);
//        path.arcTo(rect2, -180, 225, false);
//        path.lineTo(400, 542);


        paint.setStyle(Paint.Style.FILL);
        RectF rect1 = new RectF(200, 200, 400, 400);
        RectF rect2 = new RectF(400, 200, 600, 400);
        path.arcTo(rect1, -225, 225);
        path.arcTo(rect2, -180, 225, false);
        path.lineTo(400, 542);

//        (2)空心1
//        paint.setStyle(Paint.Style.STROKE);
//        RectF rect1 = new RectF(200, 200, 400, 400);
//        RectF rect2 = new RectF(400, 200, 600, 400);
//        path.addArc(rect1, -225, 225);
//        path.arcTo(rect2, -180, 225, false);
//        path.lineTo(400, 542);
//        path.close();
//        空心2
//        paint.setStyle(Paint.Style.STROKE);
//        RectF rect1 = new RectF(200, 200, 400, 400);
//        RectF rect2 = new RectF(400, 200, 600, 400);
//        path.arcTo(rect1, -225, 225);
//        path.arcTo(rect2, -180, 225, false);
//        path.lineTo(400, 542);
//        path.close();

        canvas.drawPath(path, paint);
    }
}
