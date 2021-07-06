package com.example.roulette.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private ScoreDao scoreDAO;
    private LiveData<List<Score>> scores;

    public ScoreRepository(Context context){
        ScoreDatabase db=ScoreDatabase.getInstance(context);
        scoreDAO=db.scoreDAO();
        scores=scoreDAO.getScores();
    }

    public LiveData<List<Score>> getScores() {
        return scores;
    }

    public void insert(Score score) {
        ScoreDatabase.executorService.execute(()->scoreDAO.insert(score));
    }

}
