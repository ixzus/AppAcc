package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        canvas.drawLine(canvas.getWidth()/4, canvas.getHeight()/4, canvas.getWidth()/4*3, canvas.getHeight()/4*3, paint);

//        paint.reset();
//        paint.setStrokeWidth(3);
//        float[] points = {100,400,300,400,200,400,200,600,100,600,300,600};
//        paint.setAntiAlias(true);
//        canvas.drawLines(points, paint);
//
//        paint.reset();
//        paint.setStrokeWidth(3);
//        float[] points1 = {400,400,600,400,400,600,600,600,400,400,400,600,600,400,600,600};
//        paint.setAntiAlias(true);
//        canvas.drawLines(points1, paint);
    }
}
