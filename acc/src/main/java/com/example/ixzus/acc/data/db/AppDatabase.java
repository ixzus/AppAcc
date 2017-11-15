package com.example.ixzus.acc.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.ixzus.acc.data.db.converter.Converters;
import com.example.ixzus.acc.data.db.dao.ProductDao;
import com.example.ixzus.acc.data.db.entity.Product;

/**
 * Created by huan on 2017/11/13.
 */
@Database(entities = {Product.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "app-acc-db";

    public abstract ProductDao dryGoodsDao();
}
