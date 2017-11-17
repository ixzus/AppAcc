package com.example.ixzus.acc.data.webservice;

import android.app.Application;

import com.example.ixzus.acc.MainActivity;
import com.example.ixzus.acc.ProductListFragment;
import com.example.ixzus.acc.data.ProductRepository;
import com.example.ixzus.acc.data.db.AppDatabase;
import com.example.ixzus.acc.data.db.RoomModule;
import com.example.ixzus.acc.data.db.dao.ProductDao;
import com.example.ixzus.acc.viewmodel.ProductListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
@Component(modules = {ApiModule.class, RoomModule.class, })
public interface ApiComponent {
    void inject(MainActivity activity);

    void inject(ProductListFragment fragment);

    void inject(ProductListViewModel viewModel);

    void inject(ProductRepository repository);

}
