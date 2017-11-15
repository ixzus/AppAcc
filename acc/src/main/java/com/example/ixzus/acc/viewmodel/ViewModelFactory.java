package com.example.ixzus.acc.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by huan on 2017/11/15.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {
    private ProductListViewModel viewModel;

    @Inject
    public ViewModelFactory(ProductListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom((ProductListViewModel.class))) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unkonwn class name");
    }
}
