package com.example.myapplication;

import android.os.CountDownTimer;
import android.service.autofill.TextValueSanitizer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Object.*;


public class MainActivity extends AppCompatActivity {

    int a=0,b=0,sum=0,step=0,fin=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button1=(Button)findViewById(R.id.button1);
        final Button button2=(Button)findViewById(R.id.button2);
        final TextView tv1=(TextView)findViewById(R.id.textView);
        final TextView tv2=(TextView)findViewById(R.id.textView2);
        final TextView tv3=(TextView)findViewById(R.id.textView3);
        final ImageButton ib1=(ImageButton)findViewById(R.id.imageButton1);
        final ImageButton ib2=(ImageButton)findViewById(R.id.imageButton2);
        final ImageButton ib3=(ImageButton)findViewById(R.id.imageButton3);
        final ImageButton ib4=(ImageButton)findViewById(R.id.imageButton4);
        final ImageButton ib5=(ImageButton)findViewById(R.id.imageButton5);
        final ImageButton ib6=(ImageButton)findViewById(R.id.imageButton6);
        final ImageButton ib7=(ImageButton)findViewById(R.id.imageButton7);
        final ImageButton ib8=(ImageButton)findViewById(R.id.imageButton8);
        button2.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        ib1.setVisibility(View.INVISIBLE);
        ib2.setVisibility(View.INVISIBLE);
        ib3.setVisibility(View.INVISIBLE);
        ib4.setVisibility(View.INVISIBLE);
        ib5.setVisibility(View.INVISIBLE);
        ib6.setVisibility(View.INVISIBLE);
        ib7.setVisibility(View.INVISIBLE);
        ib8.setVisibility(View.INVISIBLE);


       final CountDownTimer cdt = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                ((ImageButton) findViewById(R.id.imageButton1)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton2)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton3)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton4)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton5)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton6)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton7)).setImageResource(R.drawable.bg);
                ((ImageButton) findViewById(R.id.imageButton8)).setImageResource(R.drawable.bg);
            }
        };
        final CountDownTimer cdt1 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                ib1.setVisibility(View.INVISIBLE);
                ib6.setVisibility(View.INVISIBLE);
                fin++;
                if(fin==4){
                    ((TextView) findViewById(R.id.textView2)).setText(Integer.toString(step));
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        };
        final CountDownTimer cdt2 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                ib2.setVisibility(View.INVISIBLE);
                ib3.setVisibility(View.INVISIBLE);
                fin++;
                if(fin==4){
                    ((TextView) findViewById(R.id.textView2)).setText(Integer.toString(step));
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        };
        final CountDownTimer cdt3 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                ib4.setVisibility(View.INVISIBLE);
                ib7.setVisibility(View.INVISIBLE);
                fin++;
                if(fin==4){
                    ((TextView) findViewById(R.id.textView2)).setText(Integer.toString(step));
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        };
        final CountDownTimer cdt4 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                ib5.setVisibility(View.INVISIBLE);
                ib8.setVisibility(View.INVISIBLE);
                fin++;
                if(fin==4){
                    ((TextView) findViewById(R.id.textView2)).setText(Integer.toString(step));
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        };


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button1.setVisibility(View.GONE);
                ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.bg_green);
                ib1.setVisibility(View.VISIBLE);
                ib2.setVisibility(View.VISIBLE);
                ib3.setVisibility(View.VISIBLE);
                ib4.setVisibility(View.VISIBLE);
                ib5.setVisibility(View.VISIBLE);
                ib6.setVisibility(View.VISIBLE);
                ib7.setVisibility(View.VISIBLE);
                ib8.setVisibility(View.VISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.exit(0);
            }
        });
        //*******************************************
        ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton1)).setImageResource(R.drawable.bear);
                    sum++;
                    if (a == 0) {
                        a = 1;
                    } else {
                        b = 1;
                    }
                    if (a == 1 & b == 1 & sum == 2) {
                       cdt1.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton2)).setImageResource(R.drawable.bird);
                    sum++;
                    if (a == 0) {
                        a = 2;
                    } else {
                        b = 2;
                    }
                    if (a == 2 & b == 2 & sum == 2) {
                        cdt2.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton3)).setImageResource(R.drawable.bird);
                    sum++;
                    if (a == 0) {
                        a = 2;
                    } else {
                        b = 2;
                    }
                    if (a == 2 & b == 2 & sum == 2) {
                        cdt2.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton4)).setImageResource(R.drawable.cat);
                    sum++;
                    if (a == 0) {
                        a = 3;
                    } else {
                        b = 3;
                    }
                    if (a == 3 & b == 3 & sum == 2) {
                        cdt3.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton5)).setImageResource(R.drawable.fish);
                    sum++;
                    if (a == 0) {
                        a = 4;
                    } else {
                        b = 4;
                    }
                    if (a == 4 & b == 4 & sum == 2) {
                        cdt4.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton6)).setImageResource(R.drawable.bear);
                    sum++;
                    if (a == 0) {
                        a = 1;
                    } else {
                        b = 1;
                    }
                    if (a == 1 & b == 1 & sum == 2) {
                        cdt1.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton7)).setImageResource(R.drawable.cat);
                    sum++;
                    if (a == 0) {
                        a = 3;
                    } else {
                        b = 3;
                    }
                    if (a == 3 & b == 3 & sum == 2) {
                        cdt3.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        ib8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                step++;
                if(sum<2) {
                    ((ImageButton) findViewById(R.id.imageButton8)).setImageResource(R.drawable.fish);
                    sum++;
                    if (a == 0) {
                        a = 4;
                    } else {
                        b = 4;
                    }
                    if (a == 4 & b == 4 & sum == 2) {
                        cdt4.start();
                        a = 0;
                        b = 0;
                        sum = 0;
                    }
                }
                if (a != 0 & b != 0 & sum == 2) {
                    a = 0;
                    b = 0;
                    sum = 0;
                    cdt.start();
                }
            }
        });
        //***********************************************
    }

}
