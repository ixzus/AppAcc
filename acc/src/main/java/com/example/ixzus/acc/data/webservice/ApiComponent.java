package com.example.ixzus.acc.data.webservice;

import com.example.ixzus.acc.ProductListFragment;
import com.example.ixzus.acc.MainActivity;
import com.example.ixzus.acc.data.ProductRepository;
import com.example.ixzus.acc.viewmodel.ProductListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(MainActivity activity);

    void inject(ProductListFragment fragment);

    void inject(ProductListViewModel viewModel);
}
