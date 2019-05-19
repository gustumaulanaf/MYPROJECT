package com.example.gustu.myapplication;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimerService extends IntentService {
    public TimerService(){
        super("Timer Service");
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("TimerS", "onCreate: "+"Timer Start");
        for (;;){
            Locale locale = new Locale("in", "ID");
            DateFormat df = new SimpleDateFormat("EEEE,yyyy-MM-dd'T'HH.mm", locale);
            DateFormat df2 = new SimpleDateFormat("EEEE", locale);
            DateFormat jam = new SimpleDateFormat("HH.mm", locale);
            String hr = df2.format(Calendar.getInstance().getTime());
            String waktu = jam.format(Calendar.getInstance().getTime());
            String waktubagi = waktu.substring(0, 5);
            Log.d("TANNGAL", "onResume: " + waktu);

            Log.d("TimerS", "Not Null: ");
            Bundle bundle = new Bundle();
            bundle.putString("message",waktu);
            //resultReceiver.send(1234,bundle);

            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
    public int onStartCommand(Intent intent, int flags , int startId){
        super.onStartCommand(intent , flags , startId);
        return START_STICKY;
    }
    @Override
    public void onHandleIntent(Intent intent){
        if (intent==null){
            int time = intent.getIntExtra("timer",0);
            for (int i=0;i<time;i++){
                Log.d("TimerS", "onHandleIntent: "+"Time is Null");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } ;
            }
            NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
            nb.setContentText("Hello")
                    .setContentTitle("Notif").setSmallIcon(R.mipmap.ic_launcher);
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(1,nb.build());
            return;
        }
       ResultReceiver resultReceiver= intent.getParcelableExtra("receiver");
        int time=intent.getIntExtra("timer",0);


    }
}
