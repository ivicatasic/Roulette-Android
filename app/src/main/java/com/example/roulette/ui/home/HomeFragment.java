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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

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
                int sum=Integer.parseInt(dashboardViewModel.getNum3().getValue());
                int number1=getBlackWin(number,sum);

                dashboardViewModel.setWinBet(String.valueOf(number1));
                winBet.setText(String.valueOf(number1));
                int amount1= Integer.parseInt(dashboardViewModel.getAmount().getValue())+number1;
                dashboardViewModel.setAmount(String.valueOf(amount1));
                amount.setText(String.valueOf(amount1));
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

}