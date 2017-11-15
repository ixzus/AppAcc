package com.example.ixzus.acc.data.webservice;

import android.arch.lifecycle.ViewModelProvider;

import com.example.ixzus.acc.data.ProductRepository;
import com.example.ixzus.acc.viewmodel.ProductListViewModel;
import com.example.ixzus.acc.viewmodel.ViewModelFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huan on 2017/11/13.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    WebService provideWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8, TimeUnit.SECONDS)
                .connectTimeout(8, TimeUnit.SECONDS)
                .build();
    }

//    @Provides
//    @Singleton
//    ProductRepository provideProductRepository(WebService webService) {
//        return new ProductRepository(webService);
//    }
//
//    @Provides
//    @Singleton
//    ProductListViewModel privideProductListViewModel(ProductRepository repository) {
//        return new ProductListViewModel(repository);
//    }

    @Provides
    ViewModelProvider.Factory provideViewModelProviderFactory(ViewModelFactory viewModelFactory) {
        return viewModelFactory;
    }
}
