package com.example.roulette.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> resultTv;

    public HomeViewModel() {
        resultTv = new MutableLiveData<>("");

    }

    public LiveData<String> getNum() {
        return resultTv;
    }
    public void setNum(String s){this.resultTv.setValue(s);}

}