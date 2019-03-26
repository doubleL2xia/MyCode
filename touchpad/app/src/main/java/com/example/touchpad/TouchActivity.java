package com.example.touchpad;

import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;

import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
//发送的信息
//0.移动鼠标的信息：0 , velocityX , velocityY
//1.按下鼠标左键的信息:	1
//2.抬起鼠标左键的信息: 2
//3.按下鼠标右键的信息: 3
//4.抬起鼠标右键的信息: 4
public class TouchActivity extends Activity implements OnTouchListener{

    private int sensitivity = 2; //鼠标灵敏度
    Handler mHandler = MainActivity.mHandler;

    Socket mSocket;
    PrintWriter pw;

    Button btnLeft = null;
    Button btnRight = null;
    Button btnMove = null;

    GestureDetector myGestureDetector;
    public static int windowWidth;
    public static int windowHeight;
    private float o_x = 0.0f;
    private float o_y = 0.0f;
    private float c_x = 0.0f;
    private float c_y = 0.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        init();
        myGestureDetector = new GestureDetector(this, new MyGestureListener(getApplicationContext(),sensitivity));
        findViews();
        setListeners();
    }

    public boolean onTouch(View v,MotionEvent e){
        if(v.getId() == R.id.imgMove){
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                o_x = e.getX();
                o_y = e.getY();
            } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
                c_x = e.getX();
                c_y = e.getY();

                final float x = c_x - o_x;
                final float y = c_y - o_y;
                Log.i("MOVE", " " + x + " , " + y);
                new Thread() {
                    public void run() {
                        pw.println("0 " + x + " " + y);
                    }
                }.start();
                o_x = c_x;
                o_y = c_y;
            }
            //return myGestureDetector.onTouchEvent(e);
        }else{
            if(v.getId() == R.id.btnLeft){//如果点击左键
                if(e.getAction() == MotionEvent.ACTION_DOWN){//按下

                    mHandler.sendEmptyMessage(1);
                    Log.i("myTag", "按下左键");
                }else if(e.getAction() == MotionEvent.ACTION_UP){//抬起
                    mHandler.sendEmptyMessage(2);
                    Log.i("myTag", "抬起左键");
                }
            }else if(v.getId() == R.id.btnRight){//如果点击右键
                if(e.getAction() == MotionEvent.ACTION_DOWN){
                    mHandler.sendEmptyMessage(3);
                    Log.i("myTag", "按下右键");
                }else if(e.getAction() == MotionEvent.ACTION_UP){
                    mHandler.sendEmptyMessage(4);
                    Log.i("myTag", "抬起右键");
                }
            }
        }
        return true;
    }

    private void init(){
        mSocket = MainActivity.mSocket;
        pw = MainActivity.pw;

        DisplayMetrics  dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        TouchActivity.windowWidth = dm.widthPixels;
        TouchActivity.windowHeight = dm.heightPixels;
        Log.i("屏幕宽度", TouchActivity.windowWidth+" ");

    }

    private void findViews(){
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        btnMove = (Button)findViewById(R.id.imgMove);
    }

    private void setListeners(){
        btnLeft.setOnTouchListener(this);
        btnRight.setOnTouchListener(this);
        btnMove.setOnTouchListener(this);

    }
}