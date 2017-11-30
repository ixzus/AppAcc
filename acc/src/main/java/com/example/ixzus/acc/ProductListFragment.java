package com.example.ixzus.acc;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ixzus.acc.data.db.RoomModule;
import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.data.webservice.ApiModule;
import com.example.ixzus.acc.data.webservice.DaggerApiComponent;
import com.example.ixzus.acc.databinding.ListFragmentBinding;
import com.example.ixzus.acc.ui.ProductAdapter;
import com.example.ixzus.acc.ui.ProductClickCallback;
import com.example.ixzus.acc.viewmodel.ProductListViewModel;
import com.example.ixzus.acc.widget.ItemDecoration.HorizontalDividerItemDecoration;

import java.util.List;

import javax.inject.Inject;


public class ProductListFragment extends Fragment {
    public static final String TAG = "ProductListFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private ProductAdapter mAdapter;
    private ListFragmentBinding mBinding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public ProductListFragment() {
    }

    public static ProductListFragment newInstance(String param1, String param2) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);
        mAdapter = new ProductAdapter(mClaaBack);
        mBinding.productsList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).build());
        mBinding.productsList.setAdapter(mAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ui
//        DaggerApiComponent.create().inject(this);
        DaggerApiComponent.builder()
                .roomModule(new RoomModule(getActivity().getApplication()))
                .apiModule(new ApiModule())
                .build().inject(this);
        ProductListViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductListViewModel.class);
        subscribeUi(viewModel);
    }

    private void subscribeUi(ProductListViewModel viewModel) {
        viewModel.getDryGoods("Android", 10, 1).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                Log.e(TAG, "onChanged: " + products.size());
//                if (products != null ) {
                if (products.size()!=0) {
                    mBinding.setIsLoading(false);
                    mAdapter.setmListData(products);
                } else {
                    mBinding.setIsLoading(true);
                }
                mBinding.executePendingBindings();
            }
        });
    }

    private final ProductClickCallback mClaaBack = new ProductClickCallback() {
        @Override
        public void onClick(Product product) {
            Toast.makeText(getActivity(), "" + product.getDesc(), Toast.LENGTH_SHORT).show();
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity) getActivity()).show(product);
            }
        }
    };
}
