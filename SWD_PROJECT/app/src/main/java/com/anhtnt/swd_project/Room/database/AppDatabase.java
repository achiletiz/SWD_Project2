package com.anhtnt.swd_project.Room.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.anhtnt.swd_project.Room.dao.ProductDao;
import com.anhtnt.swd_project.Room.entites.OrderItem;

import static com.anhtnt.swd_project.Room.database.AppDatabase.DATABASE_VERSION;

@Database(entities = {OrderItem.class}, exportSchema = false, version = DATABASE_VERSION)
public  abstract class AppDatabase extends RoomDatabase {
    public  static  final  int DATABASE_VERSION = 1;
    public  static  final  String DATABASE_NAME = "SWD_DATABASE";
    private   static  AppDatabase INSTANCE;
    public  abstract ProductDao mProductDao();
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            .build();
                }
            }

        }
        return INSTANCE;
    }
}
