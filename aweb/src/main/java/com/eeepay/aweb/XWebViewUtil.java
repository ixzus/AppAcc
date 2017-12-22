package com.eeepay.aweb;

import com.tencent.smtt.sdk.WebView;

/**
 * Created by huan on 2017/12/22.
 */

public class XWebViewUtil {

    //方式1. 加载一个网页：
//  webView.loadUrl("http://www.google.com/");

    //方式2：加载apk包中的html页面
//  webView.loadUrl("file:///android_asset/test.html");

    //方式3：加载手机本地的html页面
//   webView.loadUrl("content://com.android.htmlfileprovider/sdcard/test.html");

    /**
     * 拦截url
     * @param webView
     */
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        //假定传入进来的 url = "js://openActivity?arg1=111&arg2=222"，代表需要打开本地页面，并且带入相应的参数
//        Uri uri = Uri.parse(url);
//        String scheme = uri.getScheme();
//        //如果 scheme 为 js，代表为预先约定的 js 协议
//        if (scheme.equals("js")) {
//            //如果 authority 为 openActivity，代表 web 需要打开一个本地的页面
//            if (uri.getAuthority().equals("openActivity")) {
//                //解析 web 页面带过来的相关参数
//                HashMap<String, String> params = new HashMap<>();
//                Set<String> collection = uri.getQueryParameterNames();
//                for (String name : collection) {
//                    params.put(name, uri.getQueryParameter(name));
//                }
//                Intent intent = new Intent(getContext(), MainActivity.class);
//                intent.putExtra("params", params);
//                getContext().startActivity(intent);
//            }
//            //代表应用内部处理完成
//            return true;
//        }
//        return super.shouldOverrideUrlLoading(view, url);
//    }

    /**
     * 点击保存图片
     * @param webView
     */
//    mWebView.setOnLongClickListener(new View.OnLongClickListener() {
//        @Override
//        public boolean onLongClick(View v) {
//            WebView.HitTestResult result = ((WebView)v).getHitTestResult();
//            if (null == result)
//                return false;
//            int type = result.getType();
//            if (type == WebView.HitTestResult.UNKNOWN_TYPE)
//                return false;
//
//            // 这里可以拦截很多类型，我们只处理图片类型就可以了
//            switch (type) {
//                case WebView.HitTestResult.PHONE_TYPE: // 处理拨号
//                    break;
//                case WebView.HitTestResult.EMAIL_TYPE: // 处理Email
//                    break;
//                case WebView.HitTestResult.GEO_TYPE: // 地图类型
//                    break;
//                case WebView.HitTestResult.SRC_ANCHOR_TYPE: // 超链接
//                    break;
//                case WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE:
//                    break;
//                case WebView.HitTestResult.IMAGE_TYPE: // 处理长按图片的菜单项
//                    // 获取图片的路径
//                    String saveImgUrl = result.getExtra();
//
//                    // 跳转到图片详情页，显示图片
//                    Intent i = new Intent(MainActivity.this, ImageActivity.class);
//                    i.putExtra("imgUrl", saveImgUrl);
//                    startActivity(i);
//                    break;
//                default:
//                    break;
//            }
//        }
//    });

    public static void clearCache(WebView webView) {
        //清除网页访问留下的缓存
        //由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
        webView.clearCache(true);
    }

    public static void clearHistory(WebView webView) {
        //清除当前webview访问的历史记录
        //只会webview访问历史记录里的所有记录除了当前访问记录
        webView.clearHistory();
    }

    public static void clearFormData(WebView webView) {
        //这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
        webView.clearFormData();
    }
}
