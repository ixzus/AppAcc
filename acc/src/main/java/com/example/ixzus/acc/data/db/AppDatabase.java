package com.example.ixzus.acc.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ixzus.acc.data.db.dao.DryGoodsDao;
import com.example.ixzus.acc.data.db.entity.DryGoods;

/**
 * Created by huan on 2017/11/13.
 */
@Database(entities = {DryGoods.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DryGoodsDao dryGoodsDao();
}
