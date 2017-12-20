package com.eeepay.awdiget.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by huan on 2017/12/19.
 */

public class RemoteControlView extends CustomView {
    private static final String TAG = "RemoteControlView";
    private Path upPath, rightPaht, downPath, leftPaht, centerPath, trianglePath;
    private Path leftupPath, rightupPath, leftdownPath, rightdownPath;
    private Region upRegion, rightRegion, downRegion, leftRegion, centerRegion;
    private Region reRU, reRD, reLD, reLU;

    private Matrix mMapMatrix = null;

    private int mCenter = 0;
    private int mUp = 1;
    private int mRight = 2;
    private int mDown = 3;
    private int mLeft = 4;
    private int mBtnRU = 5;
    private int mbtnRD = 6;
    private int mbtnLD = 7;
    private int mbtnLU = 8;

    private int touchFlag = -1;
    private int currentFalg = -1;

    int x1, y1, w1, h1;

    private OnItemClickListener onItemClickListener = null;

    private int mDefauColor = 0xFF4E5268;
    private int mTouchedColor = 0xFFDF9C81;

    public RemoteControlView(Context context) {
        this(context, null);
    }

    public RemoteControlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        centerPath = new Path();
        upPath = new Path();
        rightPaht = new Path();
        downPath = new Path();
        leftPaht = new Path();

        leftupPath = new Path();
        leftdownPath = new Path();
        rightupPath = new Path();
        rightdownPath = new Path();

        centerRegion = new Region();
        upRegion = new Region();
        rightRegion = new Region();
        downRegion = new Region();
        leftRegion = new Region();
        reLU = new Region();
        reLD = new Region();
        reRD = new Region();
        reRU = new Region();

        mPaint.setColor(mDefauColor);

        mMapMatrix = new Matrix();

        trianglePath = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMapMatrix.reset();

        Region globalRegion = new Region(-w, -h, w, h);
        int minWidth = w > h ? h : w;
        minWidth *= 0.8f;

        int bigR = (int) (minWidth * 0.5f);
        RectF outCircleRectF = new RectF(-bigR, -bigR, bigR, bigR);

        int smallR = (int) (minWidth * 0.25f);
        RectF inCircleRectF = new RectF(-smallR, -smallR, smallR, smallR);

        int centerR = (int) (minWidth * 0.2f);

//        float bigSweepAngle = (360 - 10 * 4) * 0.25f;   //80
//        float smallSweepAngle = -(360 - 10 * 4) * 0.25f;    //-80
        float bigSweepAngle = 84;   //80
        float smallSweepAngle = -80;    //-80
        float startBigSweepAngle = -bigSweepAngle * 0.5f;
        float startSamllSweepAngle = bigSweepAngle * 0.5f;

        centerPath.addCircle(0, 0, centerR, Path.Direction.CW);
        centerRegion.setPath(centerPath, globalRegion);

        rightPaht.addArc(outCircleRectF, startBigSweepAngle, bigSweepAngle);
        rightPaht.arcTo(inCircleRectF, startSamllSweepAngle, smallSweepAngle);
        rightPaht.close();
        rightRegion.setPath(rightPaht, globalRegion);

        downPath.addArc(outCircleRectF, startBigSweepAngle + 90, bigSweepAngle);
        downPath.arcTo(inCircleRectF, startSamllSweepAngle + 90, smallSweepAngle);
        downPath.close();
        downRegion.setPath(downPath, globalRegion);

        leftPaht.addArc(outCircleRectF, startBigSweepAngle + 180, bigSweepAngle);
        leftPaht.arcTo(inCircleRectF, startSamllSweepAngle + 180, smallSweepAngle);
        leftPaht.close();
        leftRegion.setPath(leftPaht, globalRegion);

        upPath.addArc(outCircleRectF, startBigSweepAngle + 270, bigSweepAngle);
        upPath.arcTo(inCircleRectF, startSamllSweepAngle + 270, smallSweepAngle);
        upPath.close();
        upRegion.setPath(upPath, globalRegion);

        int b = bigR - smallR;
        int c = (int) (b * 0.25f);
        int a = (bigR + smallR) / 2 + c / 2;
        trianglePath.moveTo(a, 0);
        trianglePath.lineTo(a - c, -c);
        trianglePath.lineTo(a - c, c);
        trianglePath.close();

//        圆点坐标：(x0,y0)
//        半径：r
//        角度：a0
//
//        则圆上任一点为：（x1,y1）
//        x1   =   x0   +   r   *   cos(ao   *   3.14   /180   )
//        y1   =   y0   +   r   *   sin(ao   *   3.14   /180   )
        int btnR = bigR;
        x1 = (int) (btnR * Math.cos(45 * Math.PI / 180));
        y1 = -(int) (btnR * Math.sin(45 * Math.PI / 180));
        w1 = 200;
        h1 = 100;
        RectF rectF1 = new RectF(x1, y1 - h1, x1 + w1, y1);
        RectF rectF2 = new RectF(x1, -(y1 - h1), x1 + w1, -y1);
        RectF rectF3 = new RectF(-x1, -(y1 - h1), -(x1 + w1), -y1);
        RectF rectF4 = new RectF(-x1, y1 - h1, -(x1 + w1), y1);
        rightupPath.addRect(rectF1, Path.Direction.CW);
        Path path1 = new Path();
        path1.addCircle(0, 0, bigR * 1.15f, Path.Direction.CW);
        rightupPath.op(path1, Path.Op.DIFFERENCE);
        reRU.setPath(rightupPath, globalRegion);

        rightdownPath.addRect(rectF2, Path.Direction.CW);
        rightdownPath.op(path1, Path.Op.DIFFERENCE);
        reRD.setPath(rightdownPath, globalRegion);

        leftdownPath.addRect(rectF3, Path.Direction.CW);
        leftdownPath.op(path1, Path.Op.DIFFERENCE);
        reLD.setPath(leftdownPath, globalRegion);

        leftupPath.addRect(rectF4, Path.Direction.CW);
        leftupPath.op(path1, Path.Op.DIFFERENCE);
        reLU.setPath(leftupPath, globalRegion);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth * 0.5f, mHeight * 0.5f);

        if (mMapMatrix.isIdentity()) {
            canvas.getMatrix().invert(mMapMatrix);
        }
        canvas.drawPath(centerPath, mPaint);
        canvas.drawPath(rightPaht, mPaint);
        canvas.drawPath(downPath, mPaint);
        canvas.drawPath(leftPaht, mPaint);
        canvas.drawPath(upPath, mPaint);
        canvas.drawPath(rightupPath, mPaint);
        canvas.drawPath(rightdownPath, mPaint);
        canvas.drawPath(leftupPath, mPaint);
        canvas.drawPath(leftdownPath, mPaint);

        mPaint.setColor(mTouchedColor);
        if (currentFalg == mCenter) {
            canvas.drawPath(centerPath, mPaint);
        } else if (currentFalg == mUp) {
            canvas.drawPath(upPath, mPaint);
        } else if (currentFalg == mRight) {
            canvas.drawPath(rightPaht, mPaint);
        } else if (currentFalg == mDown) {
            canvas.drawPath(downPath, mPaint);
        } else if (currentFalg == mLeft) {
            canvas.drawPath(leftPaht, mPaint);
        } else if (currentFalg == mBtnRU) {
            canvas.drawPath(rightupPath, mPaint);
        } else if (currentFalg == mbtnRD) {
            canvas.drawPath(rightdownPath, mPaint);
        } else if (currentFalg == mbtnLD) {
            canvas.drawPath(leftdownPath, mPaint);
        } else if (currentFalg == mbtnLU) {
            canvas.drawPath(leftupPath, mPaint);
        }

        //
        for (int i = 0; i < 4; ++i) {
            mPaint.setColor(Color.WHITE);
            canvas.drawPath(trianglePath, mPaint);
            canvas.rotate(90);
        }

        mPaint.setTextSize(36);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("暂停", 0, 36 / 3, mPaint);
        canvas.drawText("退出", x1 + w1 / 2, y1 -h1/3, mPaint);
        canvas.drawText("返回", x1 + w1 / 2, -(y1 -h1/2), mPaint);
        canvas.drawText("频道", -(x1 + w1 / 2), -(y1 -h1/2), mPaint);
        canvas.drawText("导视", -(x1 + w1 / 2), y1 -h1/3, mPaint);

        mPaint.setColor(mDefauColor);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        float[] pts = new float[2];
        pts[0] = event.getX();
        pts[1] = event.getY();
        mMapMatrix.mapPoints(pts);
        int x = (int) pts[0];
        int y = (int) pts[1];
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                touchFlag = getTouchedPaht(x, y);
                currentFalg = touchFlag;
                Log.e(TAG, "onTouchEvent: " + x + "*" + y);
                Log.e(TAG, "onTouchEvent: " + touchFlag);
                break;
            case MotionEvent.ACTION_MOVE:
                currentFalg = getTouchedPaht(x, y);
                break;
            case MotionEvent.ACTION_UP:
                currentFalg = getTouchedPaht(x, y);
                if (onItemClickListener != null && currentFalg != -1 && currentFalg == touchFlag) {
                    if (currentFalg == mCenter) {
                        onItemClickListener.onCenterClick();
                    } else if (currentFalg == mUp) {
                        onItemClickListener.onUpClick();
                    } else if (currentFalg == mRight) {
                        onItemClickListener.onRightClick();
                    } else if (currentFalg == mDown) {
                        onItemClickListener.onDownClick();
                    } else if (currentFalg == mLeft) {
                        onItemClickListener.onLeftClick();
                    }
                }
                touchFlag = currentFalg = -1;
                break;
            case MotionEvent.ACTION_CANCEL:
                touchFlag = -1;
                break;
        }
        invalidate();
        return true;
    }

    private int getTouchedPaht(int x, int y) {
        if (centerRegion.contains(x, y)) {
            return 0;
        } else if (upRegion.contains(x, y)) {
            return 1;
        } else if (rightRegion.contains(x, y)) {
            return 2;
        } else if (downRegion.contains(x, y)) {
            return 3;
        } else if (leftRegion.contains(x, y)) {
            return 4;
        } else if (reRU.contains(x, y)) {
            return 5;
        } else if (reRD.contains(x, y)) {
            return 6;
        } else if (reLD.contains(x, y)) {
            return 7;
        } else if (reLU.contains(x, y)) {
            return 8;
        }
        return -1;
    }

    /**
     * 对外接口
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCenterClick();

        void onUpClick();

        void onRightClick();

        void onDownClick();

        void onLeftClick();
    }
}
