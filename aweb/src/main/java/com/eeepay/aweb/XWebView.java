package com.eeepay.aweb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class XWebView extends WebView {
    private ProgressBar progressbar;
    private int progressHeight = 3;
    private TextView title;
    private List<String> listHistory = new ArrayList<>();

    public List<String> getListHistory() {
        return listHistory;
    }

    public XWebView(Context arg0) {
        this(arg0, null);

    }

    @SuppressLint("SetJavaScriptEnabled")
    public XWebView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        setBackgroundColor(85621);
        this.setWebViewClient(client);
        this.setWebChromeClient(chromeClient);
        // WebStorage webStorage = WebStorage.getInstance();
        initWebViewSettings(arg0);
        this.getView().setClickable(true);
    }


    private void initWebViewSettings(Context context) {
        WebSettings webSetting = this.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

        // this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
        // settings 的设计

        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, progressHeight, 0));
        Drawable drawable = context.getResources().getDrawable(R.drawable.progressbar_loading);
        progressbar.setProgressDrawable(drawable);
        addView(progressbar);
        if (null != getX5WebViewExtension()) {
            getX5WebViewExtension().setScrollBarFadingEnabled(false);
        }

    }

    private WebViewClient client = new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("weixin://wap/pay?") || url.startsWith("weixin") || url.startsWith("wechat")
                    || url.startsWith("mqqapi") || url.startsWith("mqqwpa")
                    || url.startsWith("alipays:") || url.startsWith("alipay")) {
                try {
                    getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

            }
            if (!(url.startsWith("http") || url.startsWith("https"))) {
//                view.loadUrl(url);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            //https 忽略证书
            sslErrorHandler.proceed();
        }


        @Override
        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
            listHistory.add(s);
            super.onPageStarted(webView, s, bitmap);
        }

        @Override
        public void onPageFinished(WebView webView, String s) {
//            if (onXWebViewListener != null) {
//                onXWebViewListener.onPageFinish(webView);
//            }
            super.onPageFinished(webView, s);
        }
    };


    private WebChromeClient chromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(final WebView webView, int i) {
            if (i == 100) {
                progressbar.setProgress(100);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressbar.setVisibility(GONE);
                        progressbar.setProgress(0);
                        if (onXWebViewListener != null) {
                            onXWebViewListener.onPageFinish(webView);
                        }
                    }
                }, 300);
            } else {
                if (progressbar.getVisibility() == GONE) {
                    progressbar.setVisibility(VISIBLE);
                }
                progressbar.setProgress(i);
            }
            if (onXWebViewListener != null) {
                onXWebViewListener.onProgressChange(webView, i);
            }
            super.onProgressChanged(webView, i);
        }

        @Override
        public void onReceivedTitle(WebView webView, String s) {
            super.onReceivedTitle(webView, s);
            if (onXWebViewListener != null) {
                onXWebViewListener.onTitle(s);
            }
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String s, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            //local
            geolocationPermissionsCallback.invoke(s,true,false);
            super.onGeolocationPermissionsShowPrompt(s, geolocationPermissionsCallback);
        }
    };


    private onXWebViewListener onXWebViewListener;

    public void setOnXWebViewListener(XWebView.onXWebViewListener onXWebViewListener) {
        this.onXWebViewListener = onXWebViewListener;
    }

    public interface onXWebViewListener {
        void onProgressChange(WebView webView, int progress);

        void onPageFinish(WebView webView);

        void onTitle(String title);
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean ret = super.drawChild(canvas, child, drawingTime);
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(0x7fff0000);
        paint.setTextSize(24.f);
        paint.setAntiAlias(true);
        if (getX5WebViewExtension() != null) {
            canvas.drawText(this.getContext().getPackageName() + "-pid:"
                    + android.os.Process.myPid(), 10, 50, paint);
            canvas.drawText(
                    "X5  Core:" + QbSdk.getTbsVersion(this.getContext()), 10,
                    100, paint);
        } else {
            canvas.drawText(this.getContext().getPackageName() + "-pid:"
                    + android.os.Process.myPid(), 10, 50, paint);
            canvas.drawText("Sys Core", 10, 100, paint);
        }
        canvas.drawText(Build.MANUFACTURER, 10, 150, paint);
        canvas.drawText(Build.MODEL, 10, 200, paint);
        canvas.restore();
        return ret;
    }

}
