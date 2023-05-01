package com.example.pract5.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pract5.data.db.dao.SubDao;
import com.example.pract5.data.db.entities.SublistItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {SublistItem.class}, version = 1, exportSchema = false)
public abstract class SubDB extends RoomDatabase {

    private static volatile SubDB INSTANCE;

    public abstract SubDao subDao();

    public static SubDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SubDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SubDB.class, "sub_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
