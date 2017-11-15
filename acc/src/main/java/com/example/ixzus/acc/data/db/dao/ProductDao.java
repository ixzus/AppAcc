package com.example.ixzus.acc.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ixzus.acc.data.db.entity.Product;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by huan on 2017/11/13.
 */
@Dao
public interface ProductDao {

    @Insert(onConflict = REPLACE)
    void insert(Product product);

    @Insert(onConflict = REPLACE)
    void insertAll(List<Product> listDryGoods);

    @Delete
    void delete(Product product);

    @Update
    void update(Product... dryGoods);


    @Query("SELECT * FROM Product WHERE type = :type")
    MutableLiveData<List<Product>> loadByType(String type);

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> loadAll();

}
