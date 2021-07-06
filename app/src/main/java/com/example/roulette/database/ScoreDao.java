package com.example.roulette.database;


import androidx.lifecycle.LiveData;
import androidx.room.*;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Score score);

    @Query("SELECT * FROM score ORDER BY score_name ASC")
    LiveData<List<Score>> getScores();
}
