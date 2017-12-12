package com.eeepay.modulebase.net;

/**
 * Created by ixzus on 2017/11/28.
 */

public interface DataCallBack<T> {

    void onSuccess(T data);

    void onError(int code, String errorMessage);

}
