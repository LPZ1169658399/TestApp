package com.example.testapp;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends Activity {

    private Handler threadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        new MyThread().start();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                threadHandler.sendEmptyMessage(2);
                break;
            default:break;
        }
    }


    class MyThread extends Thread{
        @Override
        public void run() {
            Looper.prepare();
            threadHandler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    Log.i("MyTag","message:"+msg.what);
                }
            };
            Looper.loop();
        }
    }


}
