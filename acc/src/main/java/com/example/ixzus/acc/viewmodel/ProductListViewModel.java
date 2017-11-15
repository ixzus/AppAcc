package com.example.ixzus.acc.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.ixzus.acc.data.ProductRepository;
import com.example.ixzus.acc.data.db.entity.Product;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by huan on 2017/11/13.
 */

public class ProductListViewModel extends ViewModel {
    private MutableLiveData<List<Product>> mObasevableProducts;

    private ProductRepository repository;

    @Inject
    public ProductListViewModel(ProductRepository repository) {
        this.repository = repository;
    }


    public MutableLiveData<List<Product>> getDryGoods(String type, int pageSize, int pageNo) {
        if (this.mObasevableProducts == null) {
            mObasevableProducts = new MutableLiveData<>();
            loadData(type, pageSize, pageNo);
        }
        return mObasevableProducts;
    }

    private void loadData(String type, int pageSize, int pageNo) {
        mObasevableProducts = repository.getProducts(type, pageSize, pageNo);
    }

}
