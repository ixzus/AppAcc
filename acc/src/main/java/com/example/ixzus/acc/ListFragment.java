package com.example.ixzus.acc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ixzus.acc.data.webservice.DaggerApiComponent;
import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.DryGoods;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    public static final String TAG = "ListFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @Inject
    WebService webService;

    public ListFragment() {
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        DaggerApiComponent.create().inject(this);
//        Call<DryGoods> dryGoodsCall = webService.getDryGoods("Android", 10, 1);
//        dryGoodsCall.enqueue(new Callback<DryGoods>() {
//            @Override
//            public void onResponse(Call<DryGoods> call, Response<DryGoods> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<DryGoods> call, Throwable t) {
//
//            }
//        });
    }
}
