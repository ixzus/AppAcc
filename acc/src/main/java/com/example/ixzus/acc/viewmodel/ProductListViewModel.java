package com.example.ixzus.acc.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.ixzus.acc.data.ProductRepository;
import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.data.webservice.DaggerApiComponent;
import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.DryGoodsRst;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huan on 2017/11/13.
 */

public class ProductListViewModel extends ViewModel {
    private MutableLiveData<List<Product>> mObasevableProducts ;
//    private ProductRepository repository;

    @Inject
    WebService webService;


    public ProductListViewModel( ){

    }

    public void init(String type, int pageSize, int pageNo) {
        if (this.mObasevableProducts != null)
            return;
        mObasevableProducts = new MutableLiveData<>();
//        mObasevableProducts = repository.getDryGoods(type, pageSize, pageNo);
        final MutableLiveData<DryGoodsRst> data = new MutableLiveData<>();
        DaggerApiComponent.create().inject(this);
        webService.getDryGoods(type, pageSize, pageNo).enqueue(new Callback<DryGoodsRst>() {
            @Override
            public void onResponse(Call<DryGoodsRst> call, Response<DryGoodsRst> response) {
                data.setValue(response.body());
                mObasevableProducts.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<DryGoodsRst> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Product>> getDryGoods() {
        return this.mObasevableProducts;
    }

}
