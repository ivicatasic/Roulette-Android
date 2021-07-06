package com.example.roulette.ui.notifications;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roulette.database.Score;
import com.example.roulette.database.ScoreRepository;

import java.util.List;

public class NotificationsViewModel extends AndroidViewModel {



    private ScoreRepository repository;
    private LiveData<List<Score>> scores;

    public NotificationsViewModel(@NonNull final Application application) {
        super(application);
        repository=new ScoreRepository(application);
        scores= repository.getScores();

    }

    public void insert(Score score){
        repository.insert(score);
    }
    public LiveData<List<Score>> getScores(){
        return scores;
    }

}