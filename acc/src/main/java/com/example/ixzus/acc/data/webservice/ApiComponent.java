package com.example.ixzus.acc.data.webservice;

import com.example.ixzus.acc.ListFragment;
import com.example.ixzus.acc.MainActivity;
import com.example.ixzus.acc.data.DryGoodsRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(MainActivity activity);

//    void inject(ListFragment fragment);

    void inject(DryGoodsRepository repository);
}
