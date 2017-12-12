package com.example.ixzus.acc.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SimpleItemDecoration extends RecyclerView.ItemDecoration {

    private int orientation;

    private Drawable drawable;

    public SimpleItemDecoration(@NonNull int orientation, @NonNull Drawable drawable) {
        this.orientation = orientation;
        this.drawable = drawable;
    }

    /**
     * 设置RecyclerView的布局管理器
     * @param orientation
     */
    public void setOrientation(int orientation) {
        if (LinearLayoutManager.HORIZONTAL != orientation && LinearLayoutManager.VERTICAL != orientation)
            new IllegalArgumentException("RecyclerView不支持此布局管理器");

        this.orientation = orientation;
    }

    /**
     * 获得条目偏移量 ， 回调此方法来确定每个Item的偏移量
     * @param outRect 矩形区域 , 每一个Item都是一个矩形区域，rect表示矩形区域的四个方位
     * @param view 每个条目的View对象
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (LinearLayoutManager.VERTICAL == orientation) {
            outRect.set(0,0,0,drawable.getIntrinsicHeight()); // 将drawable绘制在Item的底部
        }else if (LinearLayoutManager.HORIZONTAL == orientation) {
            outRect.set(0,0,drawable.getIntrinsicWidth(),0); // 将drawable绘制在Item的右边
        }
    }

    /**
     * 间隔线绘制
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (LinearLayoutManager.VERTICAL == orientation) {
            drawHorizontalLine(c,parent); //画水平线
        }else if (LinearLayoutManager.HORIZONTAL == orientation) {
            drawVerticalLine(c,parent); // 画垂直线
        }
    }

    /**
     * 画水平线
     * @param c 画布
     * @param parent
     */
    private void drawHorizontalLine(Canvas c, RecyclerView parent) {

        int left = parent.getPaddingLeft(); // 从recyclerView容器内边距算起 ， 左边起点坐标
        int right = parent.getWidth() - parent.getPaddingRight(); // recyclerView宽度减去paddingRight计算右边坐标
        // 以上 , Item decoration的宽度坐标确定 ， 即rect的长度

        int childCount = parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int top = childView.getBottom() + layoutParams.bottomMargin + Math.round(ViewCompat.getTranslationY(childView));
            int bottom = top + drawable.getIntrinsicHeight();
            // 每一个Item都需要绘制一遍
            drawable.setBounds(left,top,right,bottom);
            drawable.draw(c);
        }
    }

    /**
     * 画垂直线
     * @param canvas
     * @param parent
     */
    private void drawVerticalLine(Canvas canvas,RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {

            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getRight() + layoutParams.rightMargin + Math.round(ViewCompat.getTranslationX(childView));
            int right = left + drawable.getIntrinsicWidth();

            drawable.setBounds(left,top,right,bottom);
            drawable.draw(canvas);
        }
    }
}