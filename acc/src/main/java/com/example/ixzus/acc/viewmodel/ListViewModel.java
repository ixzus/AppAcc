package com.example.ixzus.acc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.ixzus.acc.data.DryGoodsRepository;
import com.example.ixzus.acc.data.webservice.entity.DryGoods;

/**
 * Created by huan on 2017/11/13.
 */

public class ListViewModel extends ViewModel {
    private LiveData<DryGoods> dryGoods;
    private DryGoodsRepository repository;

    public ListViewModel(DryGoodsRepository repository) {
        this.repository = repository;
    }

    public void init(String type, int pageSize, int pageNo) {
        if (this.dryGoods != null) {
            return;
        }
        dryGoods = repository.getDryGoods(type, pageSize, pageNo);
    }

    public LiveData<DryGoods> getDryGoods() {
        return dryGoods;
    }
}
