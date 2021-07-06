package com.example.roulette.ui.dashboard;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.roulette.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private int clickNumber1;
    private int clickNumber2;
    private int clickNumber3;
    private int clickNumber4;
    private int clickNumber5;
    private boolean selectChip1;
    private boolean selectChip2;
    private boolean selectChip3;
    private boolean selectChip4;
    private boolean selectChip5;
    Button clearAllBet;
    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView amount;
    TextView bet;
    TextView WinBet;
    int sumBets;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        clickNumber1 = 0;
        clickNumber2 = 0;
        clickNumber3 = 0;
        clickNumber4 = 0;
        clickNumber5 = 0;
        selectChip1 = false;
        selectChip2 = false;
        selectChip3 = false;
        selectChip4 = false;
        selectChip5 = false;
        sumBets=0;


/* set click listener on image chip */

        ImageView image1 = root.findViewById(R.id.chip_1);
        ImageView image2 = root.findViewById(R.id.chip_5);
        ImageView image3 = root.findViewById(R.id.chip_10);
        ImageView image4 = root.findViewById(R.id.chip_20);
        ImageView image5 = root.findViewById(R.id.chip_50);

        image1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                clickNumber1++;
                if (clickNumber1 % 2 != 0 && !selectChip2 && !selectChip3 && !selectChip4 && !selectChip5) {
                    image1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectChip1 = true;
                } else {
                    image1.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    selectChip1 = false;
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                clickNumber2++;
                if (clickNumber2 % 2 != 0 && !selectChip1 && !selectChip3 && !selectChip4 && !selectChip5) {
                    image2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectChip2 = true;
                } else {
                    image2.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    selectChip2 = false;
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                clickNumber3++;
                if (clickNumber3 % 2 != 0 && !selectChip1 && !selectChip2 && !selectChip4 && !selectChip5) {
                    image3.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectChip3 = true;
                } else {
                    image3.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    selectChip3 = false;
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                clickNumber4++;
                if (clickNumber4 % 2 != 0 && !selectChip1 && !selectChip2 && !selectChip3 && !selectChip5) {
                    image4.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectChip4 = true;
                } else {
                    image4.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    selectChip4 = false;
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                clickNumber5++;
                if (clickNumber5 % 2 != 0 && !selectChip2 && !selectChip3 && !selectChip4 && !selectChip1) {
                    image5.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectChip5 = true;
                } else {
                    image5.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    selectChip5 = false;
                }
            }
        });

/*  //////add click on board and set chips////////// */

        clearAllBet= root.findViewById(R.id.clear_all_bet);

        num1 = root.findViewById(R.id.num1);
        num1.setText(dashboardViewModel.getNum1().getValue());
        amount=root.findViewById(R.id.sumAmount);
        amount.setText(dashboardViewModel.getAmount().getValue());
        bet=root.findViewById(R.id.sumBet);
        bet.setText(dashboardViewModel.getBet().getValue());

        num2=root.findViewById(R.id.num2);
        num2.setText(dashboardViewModel.getNum2().getValue());

        num3=root.findViewById(R.id.num3);
        num3.setText(dashboardViewModel.getNum3().getValue());

        num4=root.findViewById(R.id.num4);
        num4.setText(dashboardViewModel.getNum4().getValue());

        num5=root.findViewById(R.id.num5);
        num5.setText(dashboardViewModel.getNum5().getValue());

        num6=root.findViewById(R.id.num6);
        num6.setText(dashboardViewModel.getNum6().getValue());

        WinBet=root.findViewById(R.id.sumWinning_bet);
        WinBet.setText(dashboardViewModel.getWinBet().getValue());

        clearAllBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllBet();
            }
        });


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip1();
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addChip2();
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip3();
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip4();
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip5();
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip6();
            }
        });




        return root;
    }

    public void clearAllBet(){
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int sumBet= Integer.parseInt(dashboardViewModel.getBet().getValue());

        int num1= Integer.parseInt(dashboardViewModel.getNum1().getValue());
        int num2= Integer.parseInt(dashboardViewModel.getNum2().getValue());
        int num3= Integer.parseInt(dashboardViewModel.getNum3().getValue());
        int num4= Integer.parseInt(dashboardViewModel.getNum4().getValue());
        int num5= Integer.parseInt(dashboardViewModel.getNum5().getValue());
        int num6= Integer.parseInt(dashboardViewModel.getNum6().getValue());

        amount+=num1+num2+num3+num4+num5+num6;
        sumBet-=num1-num2-num3-num4-num5-num6;

        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet("0");
        dashboardViewModel.setNum1("0");
        dashboardViewModel.setNum2("0");
        dashboardViewModel.setNum3("0");
        dashboardViewModel.setNum4("0");
        dashboardViewModel.setNum5("0");
        dashboardViewModel.setNum6("0");

        this.amount.setText(String.valueOf(amount));
        this.bet.setText("0");
        this.num1.setText("0");
        this.num2.setText("0");
        this.num3.setText("0");
        this.num4.setText("0");
        this.num5.setText("0");
        this.num6.setText("0");

    }

    public void addChip1() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num1= Integer.parseInt(dashboardViewModel.getNum1().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num1+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num1+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num1+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num1+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num1+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum1(String.valueOf(num1));
        this.num1.setText(String.valueOf(num1));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }

    public void addChip2() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num2= Integer.parseInt(dashboardViewModel.getNum2().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num2+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num2+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num2+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num2+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num2+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum2(String.valueOf(num2));
        this.num2.setText(String.valueOf(num2));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }


    public void addChip3() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num3= Integer.parseInt(dashboardViewModel.getNum3().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num3+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num3+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num3+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num3+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num3+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum3(String.valueOf(num3));
        this.num3.setText(String.valueOf(num3));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }

    public void addChip4() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num4= Integer.parseInt(dashboardViewModel.getNum4().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num4+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num4+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num4+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num4+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num4+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum4(String.valueOf(num4));
        this.num4.setText(String.valueOf(num4));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip5() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num5= Integer.parseInt(dashboardViewModel.getNum5().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num5+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num5+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num5+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num5+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num5+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum5(String.valueOf(num5));
        this.num5.setText(String.valueOf(num5));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip6() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num6= Integer.parseInt(dashboardViewModel.getNum6().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num6+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num6+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num6+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num6+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num6+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum6(String.valueOf(num6));
        this.num6.setText(String.valueOf(num6));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }

}