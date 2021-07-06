package com.example.roulette.ui.dashboard;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roulette.R;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> num1;
    public MutableLiveData<String> amount;
    private MutableLiveData<String> bet;
    private MutableLiveData<String> num2;
    private MutableLiveData<String> num3;
    private MutableLiveData<String> num4;
    private MutableLiveData<String> num5;
    private MutableLiveData<String> num6;
    private MutableLiveData<String> winBet;
    public DashboardViewModel() {

        num1 = new MutableLiveData<>("0");
        amount=new MutableLiveData<>("10000");
        bet= new MutableLiveData<>("0");
        num2= new MutableLiveData<>("0");
        num3= new MutableLiveData<>("0");
        num4= new MutableLiveData<>("0");
        num5= new MutableLiveData<>("0");
        num6= new MutableLiveData<>("0");
        winBet= new MutableLiveData<>("0");

    }

    public LiveData<String> getNum1() {
        return num1;
    }
    public LiveData<String> getAmount(){
        return amount;
    }
    public LiveData<String> getBet(){
        return bet;
    }
    public LiveData<String> getNum2() {
        return num2;
    }
    public LiveData<String> getNum3() {
        return num3;
    }
    public LiveData<String> getNum4() {
        return num4;
    }
    public LiveData<String> getNum5() {
        return num5;
    }
    public LiveData<String> getNum6() {
        return num6;
    }
    public LiveData<String> getWinBet() {
        return winBet;
    }

    public void setNum1(String s){num1.setValue(s);}
    public void setNum2(String s){num2.setValue(s);}
    public void setNum3(String s){num3.setValue(s);}
    public void setNum4(String s){num4.setValue(s);}
    public void setNum5(String s){num5.setValue(s);}
    public void setNum6(String s){num6.setValue(s);}

    public void setAmount(String s){amount.setValue(s);}
    public void setBet(String s){bet.setValue(s);}
    public void setWinBet(String s){winBet.setValue(s);}

}