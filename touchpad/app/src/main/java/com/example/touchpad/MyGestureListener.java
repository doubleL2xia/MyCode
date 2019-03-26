package com.example.touchpad;

import java.io.PrintWriter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class MyGestureListener extends SimpleOnGestureListener {
    private Context mContext = null;
    private int sensitivity;
    private int windowWidth12;//1/2屏幕宽度
    private int windowHeight;//屏幕高度
    private PrintWriter pw;

    private int leftMaxX;
    private int rightMinX;
    private int bottomMinY;

    private boolean isTriggering = false;

    private final String myTag = "MyTag";

    public MyGestureListener(Context context, int sensitivity) {

        this.mContext = context;
        this.sensitivity = sensitivity;
        this.pw = MainActivity.pw;
        Handler mHandler = MainActivity.mHandler;
    }



    public boolean onDoubleTap(MotionEvent e) {

        if (e.getX() <= windowWidth12) {
            Log.i(myTag, "双击左半屏幕");
            new Thread() {
                public void run() {
                    pw.println(1);
                    pw.println(2);
                }
            }.start();
        } else {
            Log.i(myTag, "双击右半屏幕");
            new Thread() {
                public void run() {
                    pw.println(1);
                    pw.println(2);
                }
            }.start();
        }
        Log.i("MyTAG", e.getPointerCount() + " ");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if (e.getX() <= windowWidth12) {
            Log.i(myTag, "长按左半屏幕");
            new Thread() {
                public void run() {
                    pw.println(1);
                }
            }.start();
        } else {
            Log.i(myTag, "长按右半屏幕");
            new Thread() {
                public void run() {
                    pw.println(1);
                }
            }.start();
        }
    }

}