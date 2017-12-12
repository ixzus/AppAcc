package com.eeepay.modulebase.event;

/**
 * Created by huan on 2017/11/30.
 */

public class MessageEvent<T> {
    private String eventcode;
    private T data;

    public MessageEvent(String eventcode, T data) {
        this.eventcode = eventcode;
        this.data = data;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
