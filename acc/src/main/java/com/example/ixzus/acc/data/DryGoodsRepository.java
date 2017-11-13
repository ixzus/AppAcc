package com.example.ixzus.acc.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.DryGoods;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
public class DryGoodsRepository {
    @Inject
    WebService webService;

    public LiveData<DryGoods> getDryGoods(String type, int pageSize, int pageNo){
        final MutableLiveData<DryGoods> data = new MutableLiveData<>();
        webService.getDryGoods(type, pageSize, pageNo).enqueue(new Callback<DryGoods>() {
            @Override
            public void onResponse(Call<DryGoods> call, Response<DryGoods> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DryGoods> call, Throwable t) {

            }
        });
        return data;
    }


}
