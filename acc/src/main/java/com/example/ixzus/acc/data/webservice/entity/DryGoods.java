package com.example.ixzus.acc.data.webservice.entity;

import java.util.List;

/**
 * Created by huan on 2017/11/13.
 */

public class DryGoods {

    /**
     * error : false
     * results : [{"_id":"5a085efb421aa90fe50c01f6","createdAt":"2017-11-12T22:47:23.292Z","desc":"Android持续集成：Jenkins+Github+蒲公英/Fir.im+邮件通知","publishedAt":"2017-11-13T12:10:58.643Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488151&idx=1&sn=f329687505b416cd898c843ca558b693","used":true,"who":"陈宇明"},{"_id":"5a08f676421aa90fe50c01f7","createdAt":"2017-11-13T09:33:42.968Z","desc":"Android性能优化之列表卡顿（以\u201c简书\u201d为例）","publishedAt":"2017-11-13T12:10:58.643Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488175&idx=1&sn=b8d044fdd6b534b685e84a8fdf25398b","used":true,"who":"陈宇明"},{"_id":"5a091a1d421aa90fe50c01f8","createdAt":"2017-11-13T12:05:49.452Z","desc":"兼容 RFC 3986 的 URL lib。","publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"Android","url":"https://github.com/EricEdens/urllib","used":true,"who":"代码家"},{"_id":"5a091a8a421aa90fef20351e","createdAt":"2017-11-13T12:07:38.313Z","desc":"Android Bottom Sheet 布局效果。","images":["http://img.gank.io/3fcb8ca3-fb8c-4958-9dd7-e986e3743407"],"publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"Android","url":"https://github.com/qhutch/BottomSheetLayout","used":true,"who":"代码家"},{"_id":"5a027569421aa90fe7253610","createdAt":"2017-11-08T11:09:29.236Z","desc":"免费专栏推荐：小米 MIUI 系统工程师 的《从源码角度看 Android》","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483816&idx=1&sn=9129a1fff64c6da7dde9143dc6995ec1&chksm=fdbf32ffcac8bbe943e81a23a487e3caac0dbb64e18509e61b28666074234c58e820b1a0aeea#rd","used":true,"who":null},{"_id":"5a02d0d1421aa90fe2f02c37","createdAt":"2017-11-08T17:39:29.976Z","desc":"这可能是第二好的自定义 View 教程之绘制","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/7cea643df11b","used":true,"who":"LiuShilin"},{"_id":"5a0312a9421aa90fe7253615","createdAt":"2017-11-08T22:20:25.632Z","desc":"雕虫晓技(一) Android 组件化","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzI3MzMzNjgzMA==&mid=2247483674&idx=1&sn=fc93e05445a8fefcde0fdfb2c0145321&chksm=eb25918bdc52189d3ce82d7796ec95105927734d0cf47544126937d3d1255f41002f0cfb3afe&mpshare=1&scene=1&srcid=1106IA3DQP1u3IkOcCVwq1u2&key=5dba587a8b06ccca4ff30ff629f458ed05559774b37f3b9080982d26a7151db05c0324f15551f87029d3a11fee57d8fd51c5622f26b109f6f59a4c6c4ee811a840d7e9862b796b9dbdea8c14a1d32e9f&ascene=0&uin=NjM4NDkwNzgy&devicetype=iMac+MacBookAir7%2C2+OSX+OSX+10.12.4+build(16E195)&version=12010110&nettype=WIFI&fontScale=100&pass_ticket=wtm7nx0Fp2owsbSKcyoiIgV4pVu0Rw0GZicnXakuWo0tyipA8VCHAfpOkJGhp3yb","used":true,"who":"sloop"},{"_id":"5a03b2aa421aa90fe50c01e9","createdAt":"2017-11-09T09:43:06.493Z","desc":"我所理解的Android和iOS上的View","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/W9lRR4K3XRNTPvXf64qdhA","used":true,"who":"D_clock"},{"_id":"5a03ee2c421aa90fe7253619","createdAt":"2017-11-09T13:57:00.165Z","desc":"Kotlin 系列 - 从0到1 开发一个 App","images":["http://img.gank.io/35be6898-b5b8-4fa9-8b60-e49c6d6b998c"],"publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"http://caimuhao.com/2017/11/02/Learn-Kotlin-While-Developing-An-Android-App-Introduction/","used":true,"who":null},{"_id":"5a041483421aa90fe2f02c3f","createdAt":"2017-11-09T16:40:35.807Z","desc":"那些年遇到的奇葩后台写的奇葩接口","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/5a723f0b7c1e","used":true,"who":"阿韦"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5a085efb421aa90fe50c01f6
         * createdAt : 2017-11-12T22:47:23.292Z
         * desc : Android持续集成：Jenkins+Github+蒲公英/Fir.im+邮件通知
         * publishedAt : 2017-11-13T12:10:58.643Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488151&idx=1&sn=f329687505b416cd898c843ca558b693
         * used : true
         * who : 陈宇明
         * images : ["http://img.gank.io/3fcb8ca3-fb8c-4958-9dd7-e986e3743407"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
