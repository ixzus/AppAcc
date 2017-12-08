package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        RectF rect = new RectF(canvas.getWidth() / 4, canvas.getHeight() / 4, canvas.getWidth() / 4 * 3, canvas.getHeight() / 4 * 3);
        canvas.drawArc(rect, 15, 150, false, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rect, 180, 60, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rect, 250, 100, true, paint);
    }
}
