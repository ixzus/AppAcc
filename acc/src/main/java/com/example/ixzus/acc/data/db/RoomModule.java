package com.example.ixzus.acc.data.db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.ixzus.acc.data.db.dao.ProductDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.ixzus.acc.data.db.AppDatabase.DATABASE_NAME;

/**
 * Created by huan on 2017/11/15.
 */
@Module
public class RoomModule {
        private Application application;

    public RoomModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    AppDatabase provideAppDatabase() {
        return Room.databaseBuilder(application, AppDatabase.class, DATABASE_NAME).build();
    }


    @Singleton
    @Provides
    ProductDao provideProductDao(AppDatabase database) {
        return database.productDao();
    }

}
