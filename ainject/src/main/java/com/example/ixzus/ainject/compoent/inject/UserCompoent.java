package com.example.ixzus.ainject.compoent.inject;

import com.example.ixzus.ainject.MainActivity;

import dagger.Component;

/**
 * Created by huan on 2017/11/3.
 */

@Component  (modules = UserModule.class)
public interface UserCompoent {
    void inject(MainActivity mainActivity);
}
