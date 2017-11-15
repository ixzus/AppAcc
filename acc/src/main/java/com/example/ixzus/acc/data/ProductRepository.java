package com.example.ixzus.acc.data;

import android.arch.lifecycle.MutableLiveData;

import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.ProductRst;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
public class ProductRepository {
    private WebService webService;

    @Inject
    public ProductRepository(WebService webService) {
        this.webService = webService;
    }

    public MutableLiveData<List<Product>> getProducts(String type, int pageSize, int pageNo) {
        final MutableLiveData<List<Product>> data = new MutableLiveData<>();
        webService.getDryGoods(type, pageSize, pageNo).enqueue(new Callback<ProductRst>() {
            @Override
            public void onResponse(Call<ProductRst> call, Response<ProductRst> response) {
                // error case is left out for brevity
                data.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ProductRst> call, Throwable t) {

            }
        });
        return data;
    }

}
