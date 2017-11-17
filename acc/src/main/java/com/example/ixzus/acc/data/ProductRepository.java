package com.example.ixzus.acc.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.ixzus.acc.data.db.dao.ProductDao;
import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.data.webservice.WebService;
import com.example.ixzus.acc.data.webservice.entity.ProductRst;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huan on 2017/11/13.
 */
@Singleton
public class ProductRepository {
    private static final String TAG = "ProductRepository";
    private WebService webService;
    private ProductDao dao;

    @Inject
    public ProductRepository(WebService webService, ProductDao dao) {
        this.webService = webService;
        this.dao = dao;
    }

    public LiveData<List<Product>> getProducts(String type, int pageSize, int pageNo) {
//        Observable.just(dao)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<ProductDao>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(ProductDao dao) {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        refreshProducts(type, pageSize, pageNo);
        return dao.loadAll();
    }

    public void refreshProducts(final String type, final int pageSize, final int pageNo) {


        webService.getDryGoods(type, pageSize, pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductRst>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductRst productRst) {
                        dao.insertAll(productRst.getResults());

                        /********************(1)***********************/
//                        Observable.empty()
//                                .doOnComplete(new Action() {
//                                    @Override
//                                    public void run() throws Exception {
//                                        dao.insertAll(productRst.getResults());
//                                    }
//                                })
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .doOnComplete(new Action() {
//                                    @Override
//                                    public void run() throws Exception {
//                                        Log.e(TAG, "accept: 多线程" );
//                                    }
//                                }).subscribe();

                        /********************(0)***********************/
//                        Observable.empty()
//                                .doOnComplete(new Action() {
//                                    @Override
//                                    public void run() throws Exception {
//                                        dao.insertAll(productRst.getResults());
//                                        Log.e(TAG, "accept: 多线程");
//                                    }
//                                })
//                                .subscribeOn(Schedulers.io())
//                                .subscribe();
                        /********************(00)***********************/
//                        Observable.empty()
//                                .doOnComplete(new Action() {
//                                    @Override
//                                    public void run() throws Exception {
//                                        dao.insertAll(productRst.getResults());
//                                        Log.e(TAG, "accept: 多线程");
//                                    }
//                                })
//                                .subscribeOn(Schedulers.io())
//                                .subscribe(new Observer<Object>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Object o) {
//
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//                                        Log.e(TAG, "accept: 多线程 结束 只调完成");
//                                    }
//                                });


                        /********************(2)***********************/
//                        Observable.empty()
//                                .observeOn(Schedulers.io())
//                                .subscribe(
//                                        obj -> {
//                                        },
//                                        e -> {
//                                        },
//                                        () -> dao.insertAll(productRst.getResults()));
                        /********************(3)***********************/
//                        Observable.just(1)
//                                .observeOn(Schedulers.io())
//                                .subscribe(a ->
//                                        dao.insertAll(productRst.getResults()));

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //                final MutableLiveData<List<Product>> data = new MutableLiveData<>();
//        webService.getDryGoods(type, pageSize, pageNo).enqueue(new Callback<ProductRst>() {
//            @Override
//            public void onResponse(Call<ProductRst> call, Response<ProductRst> response) {
//                // error case is left out for brevity
////                data.setValue(response.body().getResults());
////                dao.insertAll(response.body().getResults());
//                /*************(1)***********/
////                AsyncTask.execute(new Runnable() {
////                    @Override
////                    public void run() {
////                        dao.insertAll(response.body().getResults());
////                    }
////                });
//                /*************(2)***********/
////                new AsyncTask<Void, Void, Void>() {
////                    @Override
////                    protected void onPostExecute(Void aVoid) {
////                        super.onPostExecute(aVoid);
////                    }
////
////                    @Override
////                    protected Void doInBackground(Void... voids) {
////                        dao.insertAll(response.body().getResults());
////                        return null;
////                    }
////                }.execute();
//
//                /*************(3)***********/
////                Observable.just(dao).observeOn(Schedulers.io()).subscribe(new Consumer<ProductDao>() {
////                    @Override
////                    public void accept(ProductDao dao) throws Exception {
////                        dao.insertAll(response.body().getResults());
////                    }
////
////                });
//
//                /*************(4)***********/
//              Observable.just(1)
//                      .observeOn(Schedulers.io())
//                      .subscribe(new Consumer<Object>() {
//                          @Override
//                          public void accept(Object o) throws Exception {
//                              dao.insertAll(response.body().getResults());
//                          }
//                      });
//                /*************(5)***********/
////                Observable.just(1)
////                        .observeOn(Schedulers.io())
////                        .doOnNext(new Consumer<Integer>() {
////                            @Override
////                            public void accept(Integer integer) throws Exception {
////                                dao.insertAll(response.body().getResults());
////                            }
////                        }).subscribe(new Consumer<Integer>() {
////                    @Override
////                    public void accept(Integer integer) throws Exception {
////
////                    }
////                });
//                /*************(6)***********/
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ProductRst> call, Throwable t) {
//
//            }
//        });
    }

}
