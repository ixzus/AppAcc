package com.eeepay.aweb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private XWebView xWebView;
    private TextView tvTitle;
    private TextView loading;
    private String mUrl = "https://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUrl = getIntent().getStringExtra("url");
        frameLayout = findViewById(R.id.flLayout);
        tvTitle = findViewById(R.id.tvTitle);
        loading = findViewById(R.id.loading);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        xWebView = new XWebView(getApplicationContext(), null);
        xWebView.setLayoutParams(params);
        frameLayout.addView(xWebView);
//        xWebView = findViewById(R.id.xWebView);
        xWebView.setOnXWebViewListener(new XWebView.onXWebViewListener() {
            @Override
            public void onProgressChange(WebView webView, int progress) {
                if (loading.getVisibility() == View.GONE)
                    loading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinish(WebView webView) {
                if (loading.getVisibility() == View.VISIBLE)
                    loading.setVisibility(View.GONE);
            }

            @Override
            public void onTitle(String title) {
                if (null != title) {
                    tvTitle.setText(title.length() > 6 ? title.substring(0, 5) : title);
                }
            }
        });
        xWebView.loadUrl(mUrl);
        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                ArrayList<View> outView = new ArrayList<View>();
                getWindow().getDecorView().findViewsWithText(outView, "QQ浏览器", View.FIND_VIEWS_WITH_TEXT);
                int size = outView.size();
                if (outView != null && outView.size() > 0) {
                    outView.get(0).setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && xWebView.canGoBack()) {
            int index = xWebView.getListHistory().size();
            if (index == 0 || index == 1) {
                xWebView.goBack();
                xWebView.getListHistory().clear();
            } else {
                if (xWebView.canGoBackOrForward(-index)) {
                    xWebView.goBackOrForward(-index);
                    xWebView.getListHistory().clear();
                } else {
                    xWebView.goBack();
                    xWebView.getListHistory().clear();
                }
            }
//            xWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        xWebView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        xWebView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != xWebView) {
            frameLayout.removeView(xWebView);
            xWebView.loadUrl("about:blank");
            xWebView.stopLoading();
            xWebView.setWebChromeClient(null);
            xWebView.setWebViewClient(null);
            xWebView.destroy();
            xWebView = null;
            System.exit(0);
        }
    }
}
