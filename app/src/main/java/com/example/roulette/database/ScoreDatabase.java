package com.example.roulette.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Score.class}, version = 1, exportSchema = false)
public abstract class ScoreDatabase extends RoomDatabase {



    private static ScoreDatabase INSTANCE;
    public static ExecutorService executorService= Executors.newFixedThreadPool(2);

    public static ScoreDatabase getInstance(final Context context){
        if(INSTANCE==null){
            synchronized (ScoreDatabase.class){
                if(INSTANCE ==  null){
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(),ScoreDatabase.class,"score")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
    public  abstract ScoreDao scoreDAO();
}
