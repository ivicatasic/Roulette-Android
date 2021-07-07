package com.example.roulette.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.roulette.R;
import com.example.roulette.ui.dashboard.DashboardViewModel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView num7;
    TextView num8;
    TextView num9;
    TextView num10;
    TextView num11;
    TextView num12;
    TextView num13;
    TextView num14;
    TextView num15;
    TextView num16;
    TextView num17;
    TextView num18;
    TextView num19;
    TextView num20;
    TextView bet;



    private static final String[] sectors = { "32 RED", "15 BLACK",
            "19 RED", "4 BLACK", "21 RED", "2 BLACK", "25 RED", "17 BLACK", "34 RED",
            "6 BLACK", "27 RED","13 BLACK", "36 RED", "11 BLACK", "30 RED", "8 BLACK",
            "23 RED", "10 BLACK", "5 RED", "24 BLACK", "16 RED", "33 BLACK",
            "1 RED", "20 BLACK", "14 RED", "31 BLACK", "9 RED", "22 BLACK",
            "18 RED", "29 BLACK", "7 RED", "28 BLACK", "12 RED", "35 BLACK",
            "3 RED", "26 BLACK", "ZERO"
    };




    private int winSum;

    @BindView(R.id.spinBtn)
    Button spinBtn;
    //@BindView(R.id.resultTv)
    TextView resultTv;
    @BindView(R.id.wheel)
    ImageView wheel;

    TextView winBet;
    TextView black;
    TextView amount;
    Timer timer = new Timer();
    // We create a Random instance to make our wheel spin randomly
    private static final Random RANDOM = new Random();
    private int degree = 0, degreeOld = 0;
    // We have 37 sectors on the wheel, we divide 360 by this value to have angle for each sector
    // we divide by 2 to have a half sector
    private static final float HALF_SECTOR = 360f / 37f / 2f;


    private HomeViewModel homeViewModel;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        dashboardViewModel= new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        winSum=0;

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View root2 = inflater.inflate(R.layout.fragment_dashboard, container, false);


        ButterKnife.bind(this,root);

        resultTv=root.findViewById(R.id.resultTv);
        resultTv.setText(homeViewModel.getNum().getValue());

        winBet=root2.findViewById(R.id.sumWinning_bet);
        winBet.setText(dashboardViewModel.getWinBet().getValue());

        black=root2.findViewById(R.id.num3);
        //black.setText(dashboardViewModel.getWinBet().getValue());
        amount=root2.findViewById(R.id.sumAmount);


        bet=root2.findViewById(R.id.sumBet);
        num1=root2.findViewById(R.id.num1);
        num2=root2.findViewById(R.id.num2);
        num3=root2.findViewById(R.id.num3);
        num4=root2.findViewById(R.id.num4);
        num5=root2.findViewById(R.id.num5);
        num6=root2.findViewById(R.id.num6);
        num7=root2.findViewById(R.id.num7);
        num8=root2.findViewById(R.id.num8);
        num9=root2.findViewById(R.id.num9);
        num10=root2.findViewById(R.id.num10);
        num11=root2.findViewById(R.id.num11);
        num12=root2.findViewById(R.id.num12);
        num13=root2.findViewById(R.id.num13);
        num14=root2.findViewById(R.id.num14);
        num15=root2.findViewById(R.id.num15);
        num16=root2.findViewById(R.id.num16);
        num17=root2.findViewById(R.id.num17);
        num18=root2.findViewById(R.id.num18);
        num19=root2.findViewById(R.id.num19);
        num20=root2.findViewById(R.id.num20);

        timer = new Timer();

        return root;
    }


    @OnClick(R.id.spinBtn)
    public void spin(View v) {
        degreeOld = degree % 360;
        // we calculate random angle for rotation of our wheel
        degree = RANDOM.nextInt(360) + 720;
        // rotation effect on the center of the wheel
        RotateAnimation rotateAnim = new RotateAnimation(degreeOld, degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(3600);
        rotateAnim.setFillAfter(true);
        rotateAnim.setInterpolator(new DecelerateInterpolator());
        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // we empty the result text view when the animation start
                homeViewModel.setNum("");
                dashboardViewModel.setWinBet("0");
                winBet.setText("");
                resultTv.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // we display the correct sector pointed by the triangle at the end of the rotate animation
                String number=getSector(360 - (degree % 360));

                homeViewModel.setNum(number);
                resultTv.setText(number);
                int sumBlack=Integer.parseInt(dashboardViewModel.getNum3().getValue());
                int sumRed=Integer.parseInt(dashboardViewModel.getNum6().getValue());
                int sumPasse=Integer.parseInt(dashboardViewModel.getNum1().getValue());
                int sumPair=Integer.parseInt(dashboardViewModel.getNum2().getValue());
                int sumManque=Integer.parseInt(dashboardViewModel.getNum4().getValue());
                int sumImpair=Integer.parseInt(dashboardViewModel.getNum5().getValue());
                int sumZero=Integer.parseInt(dashboardViewModel.getNum7().getValue());
                int sumOne=Integer.parseInt(dashboardViewModel.getNum8().getValue());
                int sumTwo=Integer.parseInt(dashboardViewModel.getNum9().getValue());
                int sumThree=Integer.parseInt(dashboardViewModel.getNum10().getValue());
                int sumFour=Integer.parseInt(dashboardViewModel.getNum11().getValue());
                int sumFive=Integer.parseInt(dashboardViewModel.getNum12().getValue());
                int sumSix=Integer.parseInt(dashboardViewModel.getNum13().getValue());
                int sumSeven=Integer.parseInt(dashboardViewModel.getNum14().getValue());
                int sumEight=Integer.parseInt(dashboardViewModel.getNum15().getValue());
                int sumNine=Integer.parseInt(dashboardViewModel.getNum16().getValue());
                int sumTen=Integer.parseInt(dashboardViewModel.getNum17().getValue());
                int sumEleven=Integer.parseInt(dashboardViewModel.getNum18().getValue());

                int number1=getBlackWin(number,sumBlack);
                number1+=getRedWin(number,sumRed);
                number1+=getPasseWin(number,sumPasse);
                number1+=getPairWin(number,sumPair);
                number1+=getManqueWin(number,sumManque);
                number1+=getImpairWin(number,sumImpair);
                number1+=getZeroWin(number,sumZero);
                number1+=getOneWin(number,sumOne);
                number1+=getTwoWin(number,sumTwo);
                number1+=getThreeWin(number,sumThree);
                number1+=getFourWin(number,sumFour);
                number1+=getFiveWin(number,sumFive);
                number1+=getSixWin(number,sumSix);
                number1+=getSevenWin(number,sumSeven);
                number1+=getEightWin(number,sumEight);
                number1+=getNineWin(number,sumNine);
                number1+=getTentWin(number,sumTen);
                number1+=getEleventWin(number,sumEleven);


                dashboardViewModel.setWinBet(String.valueOf(number1));
                winBet.setText(String.valueOf(number1));
                int amount1= Integer.parseInt(dashboardViewModel.getAmount().getValue())+number1;
                dashboardViewModel.setAmount(String.valueOf(amount1));
                amount.setText(String.valueOf(amount1));

              //  timer.schedule(new Timer1(),0,500);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // we start the animation
        wheel.startAnimation(rotateAnim);
    }

    private String getSector(int degrees) {
        int i = 0;
        String text = null;

        do {
            float start = HALF_SECTOR * (i * 2 + 1);
            float end = HALF_SECTOR * (i * 2 + 3);

            if (degrees >= start && degrees < end) {
                text = sectors[i];
            }

            i++;

        } while (text == null  &&  i < sectors.length);

        return text;
    }

    public int getBlackWin(String sector, int sum){

        if(sector.equals("15 BLACK") || sector.equals("4 BLACK") || sector.equals("2 BLACK") || sector.equals("17 BLACK") || sector=="6 BLACK"
                || sector.equals("13 BLACK") || sector.equals("11 BLACK") || sector.equals("8 BLACK") || sector.equals("10 BLACK")
                || sector.equals("24 BLACK") || sector.equals("33 BLACK") || sector.equals("20 BLACK") || sector.equals("31 BLACK")
                || sector.equals("22 BLACK") || sector.equals("29 BLACK") || sector.equals("28 BLACK") || sector.equals("35 BLACK") || sector.equals("26 BLACK")
        ){
            return sum*2;
        }

        return 0;
    }

    public int getRedWin(String sector, int sum){
        if(sector.equals("1 RED") || sector.equals("3 RED") || sector.equals("5 RED") || sector.equals("7 RED") || sector=="9 RED"
                || sector.equals("12 RED") || sector.equals("14 RED") || sector.equals("16 RED") || sector.equals("18 RED")
                || sector.equals("19 RED") || sector.equals("21 RED") || sector.equals("23 RED") || sector.equals("25 RED")
                || sector.equals("27 RED") || sector.equals("30 RED") || sector.equals("32 RED") || sector.equals("34 RED") || sector.equals("36 RED")
        ){
            return sum*2;
        }

        return 0;
    }
    public int getPasseWin(String sector, int sum){
        if(sector.equals("ZERO")){
            return sum*100;
        }
        return 0;
    }
    public int getPairWin(String sector, int sum){
        if(sector.equals("26 BLACK")){
            return sum*26;
        }
        return 0;
    }
    public int getManqueWin(String sector, int sum){
        if(sector.equals("20 BLACK")){
            return sum*26;
        }
        return 0;
    }
    public int getImpairWin(String sector, int sum){
        if(sector.equals("35 BLACK")){
            return sum*26;
        }
        return 0;
    }

    public int getZeroWin(String sector, int sum){
        if(sector.equals("ZERO")){
            return sum*200;
        }
        return 0;
    }
    public int getOneWin(String sector, int sum){
        if(sector.equals("1 RED")){
            return sum*36;
        }
        return 0;
    }
    public int getTwoWin(String sector, int sum){
        if(sector.equals("2 BLACK")){
            return sum*36;
        }
        return 0;
    }
    public int getThreeWin(String sector, int sum){
        if(sector.equals("3 RED")){
            return sum*36;
        }
        return 0;
    }
    public int getFourWin(String sector, int sum){
        if(sector.equals("4 BLACK")){
            return sum*36;
        }
        return 0;
    }
    public int getFiveWin(String sector, int sum){
        if(sector.equals("5 RED")){
            return sum*36;
        }
        return 0;
    }
    public int getSixWin(String sector, int sum){
        if(sector.equals("6 BLACK")){
            return sum*36;
        }
        return 0;
    }
    public int getSevenWin(String sector, int sum){
        if(sector.equals("7 RED")){
            return sum*36;
        }
        return 0;
    }
    public int getEightWin(String sector, int sum){
        if(sector.equals("8 BLACK")){
            return sum*36;
        }
        return 0;
    }
    public int getNineWin(String sector, int sum){
        if(sector.equals("9 RED")){
            return sum*36;
        }
        return 0;
    }
    public int getTentWin(String sector, int sum){
        if(sector.equals("10 BLACK")){
            return sum*36;
        }
        return 0;
    }
    public int getEleventWin(String sector, int sum) {
        if (sector.equals("11 BLACK")) {
            return sum * 36;
        }
        return 0;
    }

    public class Timer1 extends TimerTask {


        @Override
        public void run() {
            dashboardViewModel.setBet("0");
            dashboardViewModel.setNum1("0");
            dashboardViewModel.setNum2("0");
            dashboardViewModel.setNum3("0");
            dashboardViewModel.setNum4("0");
            dashboardViewModel.setNum5("0");
            dashboardViewModel.setNum6("0");
            dashboardViewModel.setNum7("0");
            dashboardViewModel.setNum8("0");
            dashboardViewModel.setNum9("0");
            dashboardViewModel.setNum10("0");
            dashboardViewModel.setNum11("0");
            dashboardViewModel.setNum12("0");
            dashboardViewModel.setNum13("0");
            dashboardViewModel.setNum14("0");
            dashboardViewModel.setNum15("0");
            dashboardViewModel.setNum16("0");
            dashboardViewModel.setNum17("0");
            dashboardViewModel.setNum18("0");
            dashboardViewModel.setNum19("0");
            dashboardViewModel.setNum20("0");

            bet.setText("0");
            num1.setText("0");
            num2.setText("0");
            num3.setText("0");
            num4.setText("0");
            num5.setText("0");
            num6.setText("0");
            num7.setText("0");
            num8.setText("0");
            num9.setText("0");
            num10.setText("0");
            num11.setText("0");
            num12.setText("0");
            num13.setText("0");
            num14.setText("0");
            num15.setText("0");
            num16.setText("0");
            num17.setText("0");
            num18.setText("0");
            num19.setText("0");
            num20.setText("0");
        }
    }



}