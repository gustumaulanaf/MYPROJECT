package com.example.gustu.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
@SuppressLint("ParcelCreator")
public class MessageReceiver extends ResultReceiver {
    MainActivity.Message message;
    public MessageReceiver(MainActivity.Message message){
        super(new Handler());
        this.message = message;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        message.displayMessage(resultCode,resultData);
    }
}
