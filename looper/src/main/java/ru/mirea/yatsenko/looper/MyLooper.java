package ru.mirea.yatsenko.looper;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.os.Handler;

public class MyLooper extends Thread {
    int num = 0;
    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                int age = msg.getData().getInt("AGE");
                String work = msg.getData().getString("WORK");

                try {
                    Thread.sleep(age);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Log.d("MyLooper", "возраст: " + age);
                Log.d("MyLooper", "место работы: "  + work);
                num++;
            }
        };
        Looper.loop();
    }
}