package com.example.ixzus.acc.data.webservice;

import com.example.ixzus.acc.data.webservice.entity.DryGoodsRst;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by huan on 2017/11/13.
 */

public interface WebService {

    @GET("data/{type}/{pageSize}/{pageNo}")
    Call<DryGoodsRst> getDryGoods(@Path("type") String type, @Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

}
