package com.eeepay.awdiget.hencoder.practice6;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;


/**
 * Created by huan on 2017/12/13.
 */

public class AnimateUtil {
    //默认模型 AccelerateDecelerateInterpolator
    //默认时间 300ms
    private static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }

    public static ViewPropertyAnimator translationX(View view, float value) {
        return view.animate().translationX(dpToPixel(value));
    }

    public static ViewPropertyAnimator translationY(View view, float value) {
        return view.animate().translationY(dpToPixel(value));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ViewPropertyAnimator translationZ(View view, float value) {
        return view.animate().translationZ(dpToPixel(value));
    }

    public static ViewPropertyAnimator rotation(View view, float value) {
        return view.animate().rotation(value);
    }

    public static ViewPropertyAnimator rotationX(View view, float value) {
        return view.animate().rotationX(value);
    }

    public static ViewPropertyAnimator rotationY(View view, float value) {
        return view.animate().rotationY(value);
    }


    public static ViewPropertyAnimator scaleX(View view, float value) {
        return view.animate().scaleX(value);
    }

    public static ViewPropertyAnimator scaleY(View view, float value) {
        return view.animate().scaleY(value);
    }


    public static ViewPropertyAnimator alpha(View view, float value) {
        return view.animate().alpha(value);
    }

    public static ViewPropertyAnimator animateDefault(View view) {
        return view.animate().setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator());
    }

//    AccelerateDecelerateInterpolator();
//    LinearInterpolator();
//    AccelerateInterpolator();
//    DecelerateInterpolator();
//    AnticipateInterpolator();
//    OvershootInterpolator();
//    AnticipateOvershootInterpolator();
//    BounceInterpolator();
//    CycleInterpolator(0.5f);
//    PathInterpolatorCompat.create(interpolatorPath);
//    FastOutLinearInInterpolator();
//    FastOutSlowInInterpolator();
//    LinearOutSlowInInterpolator();


}
