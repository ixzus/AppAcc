package com.example.ixzus.acc.data;

import android.arch.lifecycle.MutableLiveData;

import com.example.ixzus.acc.data.db.dao.ProductDao;
import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.DryGoodsRst;

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
    //    @Inject
//    WebService webService;
    private final WebService webService;
    private final ProductDao dao;

    @Inject
    public ProductRepository(WebService webService, ProductDao dao) {
        this.webService = webService;
        this.dao = dao;
    }

    public MutableLiveData<List<Product>> getDryGoods(String type, int pageSize, int pageNo) {
        refreshDryGoods(type, pageSize, pageNo);
        return dao.loadByType(type);
    }

    private void refreshDryGoods(String type, int pageSize, int pageNo) {
        final MutableLiveData<DryGoodsRst> data = new MutableLiveData<>();
        webService.getDryGoods(type, pageSize, pageNo).enqueue(new Callback<DryGoodsRst>() {
            @Override
            public void onResponse(Call<DryGoodsRst> call, Response<DryGoodsRst> response) {
                data.setValue(response.body());
                dao.insertAll(response.body().getResults());
            }

            @Override
            public void onFailure(Call<DryGoodsRst> call, Throwable t) {

            }
        });
    }


}
