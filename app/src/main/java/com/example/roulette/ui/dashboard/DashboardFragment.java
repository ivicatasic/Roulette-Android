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

        num7=root.findViewById(R.id.num7);
        num7.setText(dashboardViewModel.getNum7().getValue());

        num8=root.findViewById(R.id.num8);
        num8.setText(dashboardViewModel.getNum8().getValue());

        num9=root.findViewById(R.id.num9);
        num9.setText(dashboardViewModel.getNum9().getValue());

        num10=root.findViewById(R.id.num10);
        num10.setText(dashboardViewModel.getNum10().getValue());

        num11=root.findViewById(R.id.num11);
        num11.setText(dashboardViewModel.getNum11().getValue());

        num12=root.findViewById(R.id.num12);
        num12.setText(dashboardViewModel.getNum12().getValue());

        num13=root.findViewById(R.id.num13);
        num13.setText(dashboardViewModel.getNum13().getValue());

        num14=root.findViewById(R.id.num14);
        num14.setText(dashboardViewModel.getNum14().getValue());

        num15=root.findViewById(R.id.num15);
        num15.setText(dashboardViewModel.getNum15().getValue());

        num16=root.findViewById(R.id.num16);
        num16.setText(dashboardViewModel.getNum16().getValue());

        num17=root.findViewById(R.id.num17);
        num17.setText(dashboardViewModel.getNum17().getValue());

        num18=root.findViewById(R.id.num18);
        num18.setText(dashboardViewModel.getNum18().getValue());

        num19=root.findViewById(R.id.num19);
        num10.setText(dashboardViewModel.getNum19().getValue());

        num20=root.findViewById(R.id.num20);
        num20.setText(dashboardViewModel.getNum20().getValue());

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
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip7();
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip8();
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip9();
            }
        });
        num10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip10();
            }
        });
        num11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip11();
            }
        });
        num12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip12();
            }
        });
        num13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip13();
            }
        });
        num14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip14();
            }
        });
        num15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip15();
            }
        });
        num16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip16();
            }
        });
        num17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip17();
            }
        });
        num18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip18();
            }
        });
        num19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip19();
            }
        });
        num20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChip20();
            }
        });


        return root;
    }

    public void clearAllBet(){
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());


        int num1= Integer.parseInt(dashboardViewModel.getNum1().getValue());
        int num2= Integer.parseInt(dashboardViewModel.getNum2().getValue());
        int num3= Integer.parseInt(dashboardViewModel.getNum3().getValue());
        int num4= Integer.parseInt(dashboardViewModel.getNum4().getValue());
        int num5= Integer.parseInt(dashboardViewModel.getNum5().getValue());
        int num6= Integer.parseInt(dashboardViewModel.getNum6().getValue());
        int num7= Integer.parseInt(dashboardViewModel.getNum7().getValue());
        int num8= Integer.parseInt(dashboardViewModel.getNum8().getValue());
        int num9= Integer.parseInt(dashboardViewModel.getNum9().getValue());
        int num10= Integer.parseInt(dashboardViewModel.getNum10().getValue());
        int num11= Integer.parseInt(dashboardViewModel.getNum11().getValue());
        int num12= Integer.parseInt(dashboardViewModel.getNum12().getValue());
        int num13= Integer.parseInt(dashboardViewModel.getNum13().getValue());
        int num14= Integer.parseInt(dashboardViewModel.getNum14().getValue());
        int num15= Integer.parseInt(dashboardViewModel.getNum15().getValue());
        int num16= Integer.parseInt(dashboardViewModel.getNum16().getValue());
        int num17= Integer.parseInt(dashboardViewModel.getNum17().getValue());
        int num18= Integer.parseInt(dashboardViewModel.getNum18().getValue());
        int num19= Integer.parseInt(dashboardViewModel.getNum19().getValue());
        int num20= Integer.parseInt(dashboardViewModel.getNum20().getValue());

        amount+=num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num11+num12+num13+num14+num15+
        num16+num17+num18+num19+num20;


        dashboardViewModel.setAmount(String.valueOf(amount));
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

        this.amount.setText(String.valueOf(amount));
        this.bet.setText("0");

        this.num1.setText("0");
        this.num2.setText("0");
        this.num3.setText("0");
        this.num4.setText("0");
        this.num5.setText("0");
        this.num6.setText("0");
        this.num7.setText("0");
        this.num8.setText("0");
        this.num9.setText("0");
        this.num10.setText("0");
        this.num11.setText("0");
        this.num12.setText("0");
        this.num13.setText("0");
        this.num14.setText("0");
        this.num15.setText("0");
        this.num16.setText("0");
        this.num17.setText("0");
        this.num18.setText("0");
        this.num19.setText("0");
        this.num20.setText("0");

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

    public void addChip7() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num7= Integer.parseInt(dashboardViewModel.getNum7().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num7+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num7+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num7+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num7+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num7+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum7(String.valueOf(num7));
        this.num7.setText(String.valueOf(num7));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }

    public void addChip8() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num8= Integer.parseInt(dashboardViewModel.getNum8().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num8+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num8+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num8+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num8+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num8+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum8(String.valueOf(num8));
        this.num8.setText(String.valueOf(num8));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip9() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num9= Integer.parseInt(dashboardViewModel.getNum9().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num9+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num9+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num9+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num9+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num9+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum9(String.valueOf(num9));
        this.num9.setText(String.valueOf(num9));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip10() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num10= Integer.parseInt(dashboardViewModel.getNum10().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num10+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num10+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num10+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num10+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num10+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum10(String.valueOf(num10));
        this.num10.setText(String.valueOf(num10));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip11() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num11= Integer.parseInt(dashboardViewModel.getNum11().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num11+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num11+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num11+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num11+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num11+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum11(String.valueOf(num11));
        this.num11.setText(String.valueOf(num11));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip12() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num12= Integer.parseInt(dashboardViewModel.getNum12().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num12+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num12+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num12+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num12+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num12+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum12(String.valueOf(num12));
        this.num12.setText(String.valueOf(num12));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip13() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num13= Integer.parseInt(dashboardViewModel.getNum13().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num13+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num13+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num13+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num13+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num13+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum13(String.valueOf(num13));
        this.num13.setText(String.valueOf(num13));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip14() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num14= Integer.parseInt(dashboardViewModel.getNum14().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num14+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num14+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num14+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num14+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num14+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum14(String.valueOf(num14));
        this.num14.setText(String.valueOf(num14));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip15() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num15= Integer.parseInt(dashboardViewModel.getNum15().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num15+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num15+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num15+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num15+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num15+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum15(String.valueOf(num15));
        this.num15.setText(String.valueOf(num15));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip16() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num16= Integer.parseInt(dashboardViewModel.getNum16().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num16+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num16+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num16+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num16+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num16+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum16(String.valueOf(num16));
        this.num16.setText(String.valueOf(num16));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip17() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num17= Integer.parseInt(dashboardViewModel.getNum17().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num17+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num17+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num17+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num17+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num17+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum17(String.valueOf(num17));
        this.num17.setText(String.valueOf(num17));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip18() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num18= Integer.parseInt(dashboardViewModel.getNum18().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num18+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num18+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num18+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num18+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num18+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum18(String.valueOf(num18));
        this.num18.setText(String.valueOf(num18));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip19() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num19= Integer.parseInt(dashboardViewModel.getNum19().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num19+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num19+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num19+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num19+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num19+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum19(String.valueOf(num19));
        this.num19.setText(String.valueOf(num19));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }
    public void addChip20() {
        int amount = Integer.parseInt(dashboardViewModel.getAmount().getValue());
        int num20= Integer.parseInt(dashboardViewModel.getNum20().getValue());
        sumBets= Integer.parseInt(dashboardViewModel.getBet().getValue());
        if (selectChip1) {
            amount = amount - 1;
            sumBets = sumBets + 1;
            num20+=1;
        } else if (selectChip2) {
            amount = amount - 5;
            sumBets = sumBets + 5;
            num20+=5;
        } else if (selectChip3) {
            amount = amount - 10;
            sumBets = sumBets + 10;
            num20+=10;
        } else if (selectChip4) {
            amount = amount - 20;
            sumBets = sumBets + 20;
            num20+=20;
        } else if (selectChip5) {
            amount = amount - 50;
            sumBets = sumBets + 50;
            num20+=50;
        }
        dashboardViewModel.setAmount(String.valueOf(amount));
        dashboardViewModel.setBet(String.valueOf(sumBets));
        dashboardViewModel.setNum20(String.valueOf(num20));
        this.num20.setText(String.valueOf(num20));
        this.amount.setText(String.valueOf(amount));
        this.bet.setText(String.valueOf(sumBets));
    }

}


































































