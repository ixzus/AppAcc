package com.eeepay.modulebase.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by huan on 2017/11/30.
 */

public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void postEvent(MessageEvent messageEvent) {
        EventBus.getDefault().post(messageEvent);
    }

    public static void postStickyEvent(MessageEvent messageEvent) {
        EventBus.getDefault().postSticky(messageEvent);
    }
}
