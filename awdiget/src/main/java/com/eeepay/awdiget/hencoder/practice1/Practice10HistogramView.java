package com.eeepay.awdiget.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private List<OSVersion> listData;
    private float maxVersion;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListData(List<OSVersion> listData) {
        this.listData = listData;
        for (OSVersion verison : listData) {
            maxVersion = Math.max(maxVersion, verison.getNumber());
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        String name = "直方图";
        paint.setColor(Color.WHITE);
        paint.setTextSize(28);
        canvas.drawText(name, (canvas.getWidth() - paint.measureText(name)) * 0.5f, canvas.getHeight() * 0.9f, paint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f);
        float[] lines = {
                0, 0, 0, -canvas.getHeight() * 0.6f,
                0, 0, canvas.getWidth() * 0.8f, 0
        };
        canvas.drawLines(lines, paint);

        float width = canvas.getWidth() * 0.8f / listData.size() * 0.8f;
        float height = canvas.getHeight() * 0.6f;
        float space = canvas.getWidth() * 0.8f / listData.size() * 0.2f;
        float startX = 0f;

        paint.setStyle(Paint.Style.FILL);
        for (OSVersion bean : listData) {
            paint.setColor(bean.getColor());
            canvas.drawRect(startX + space, -(bean.getNumber() / maxVersion * height),
                    startX + space + width, 0, paint);
            paint.setColor(Color.WHITE);
            canvas.drawText(bean.getName(),
                    startX + space + (width - paint.measureText(bean.getName())) * 0.5f, 36,
                    paint);
            startX = startX + space + width;
        }
    }
}
