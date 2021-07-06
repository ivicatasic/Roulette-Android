package com.example.roulette.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName="score")
public class Score{

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="score_id")
    public long id;

    @NonNull
    @ColumnInfo(name = "score_name")
    private String name;


    public Score(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name=name;
    }

}
