package com.example.roulette.ui.dashboard;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roulette.R;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> num1;
    private MutableLiveData<String> bet;
    private MutableLiveData<String> num2;
    private MutableLiveData<String> num3;
    private MutableLiveData<String> num4;
    private MutableLiveData<String> num5;
    private MutableLiveData<String> num6;
    private MutableLiveData<String> num7;
    private MutableLiveData<String> num8;
    private MutableLiveData<String> num9;
    private MutableLiveData<String> num10;
    private MutableLiveData<String> num11;
    private MutableLiveData<String> num12;
    private MutableLiveData<String> num13;
    private MutableLiveData<String> num14;
    private MutableLiveData<String> num15;
    private MutableLiveData<String> num16;
    private MutableLiveData<String> num17;
    private MutableLiveData<String> num18;
    private MutableLiveData<String> num19;
    private MutableLiveData<String> num20;

    private MutableLiveData<String> winBet;
    public MutableLiveData<String> amount;

    public DashboardViewModel() {

        num1 = new MutableLiveData<>("0");
        bet= new MutableLiveData<>("0");
        num2= new MutableLiveData<>("0");
        num3= new MutableLiveData<>("0");
        num4= new MutableLiveData<>("0");
        num5= new MutableLiveData<>("0");
        num6= new MutableLiveData<>("0");
        num7= new MutableLiveData<>("0");
        num8= new MutableLiveData<>("0");
        num9= new MutableLiveData<>("0");
        num10= new MutableLiveData<>("0");
        num11= new MutableLiveData<>("0");
        num12= new MutableLiveData<>("0");
        num13= new MutableLiveData<>("0");
        num14= new MutableLiveData<>("0");
        num15= new MutableLiveData<>("0");
        num16= new MutableLiveData<>("0");
        num17= new MutableLiveData<>("0");
        num18= new MutableLiveData<>("0");
        num19= new MutableLiveData<>("0");
        num20= new MutableLiveData<>("0");

        amount=new MutableLiveData<>("10000");
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
    public LiveData<String> getNum7() {
        return num7;
    }
    public LiveData<String> getNum8() {
        return num8;
    }
    public LiveData<String> getNum9() {
        return num9;
    }
    public LiveData<String> getNum10() {
        return num10;
    }
    public LiveData<String> getNum11() {
        return num11;
    }
    public LiveData<String> getNum12() {
        return num12;
    }
    public LiveData<String> getNum13() {
        return num13;
    }
    public LiveData<String> getNum14() {
        return num14;
    }
    public LiveData<String> getNum15() {
        return num15;
    }
    public LiveData<String> getNum16() {
        return num16;
    }
    public LiveData<String> getNum17() {
        return num17;
    }
    public LiveData<String> getNum18() {
        return num18;
    }
    public LiveData<String> getNum19() {
        return num19;
    }
    public LiveData<String> getNum20() {
        return num20;
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
    public void setNum7(String s){num7.setValue(s);}
    public void setNum8(String s){num8.setValue(s);}
    public void setNum9(String s){num9.setValue(s);}
    public void setNum10(String s){num10.setValue(s);}
    public void setNum11(String s){num11.setValue(s);}
    public void setNum12(String s){num12.setValue(s);}
    public void setNum13(String s){num13.setValue(s);}
    public void setNum14(String s){num14.setValue(s);}
    public void setNum15(String s){num15.setValue(s);}
    public void setNum16(String s){num16.setValue(s);}
    public void setNum17(String s){num17.setValue(s);}
    public void setNum18(String s){num18.setValue(s);}
    public void setNum19(String s){num19.setValue(s);}
    public void setNum20(String s){num20.setValue(s);}

    public void setAmount(String s){amount.setValue(s);}
    public void setBet(String s){bet.setValue(s);}
    public void setWinBet(String s){winBet.setValue(s);}

}