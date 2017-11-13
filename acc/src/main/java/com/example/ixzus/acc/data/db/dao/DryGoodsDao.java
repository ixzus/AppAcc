package com.example.ixzus.acc.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ixzus.acc.data.db.entity.DryGoods;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by huan on 2017/11/13.
 */
@Dao
public interface DryGoodsDao {

    @Insert(onConflict = REPLACE)
    void save(DryGoods dryGoods);

    @Query("SELECT * FROM drygoods WHERE id = :id")
    LiveData<DryGoods> load(String id);

}
