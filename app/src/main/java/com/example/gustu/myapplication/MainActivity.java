package com.example.gustu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tV);
        MessageReceiver messageReceiver = new MessageReceiver(new Message());

        Intent intent = new Intent(this,TimerService.class);
        intent.putExtra("timer",10);
        intent.putExtra("receiver",messageReceiver);
        startService(intent);
    }
    public class Message {
        public void displayMessage(int resultCode, Bundle resultData){
            String message = resultData.getString("message");
            Log.d("LOG", "displayMessage: "+message);
//            if (message.equals("13.31")){
//                Toast.makeText(MainActivity.this,resultCode+message,Toast.LENGTH_SHORT).show();
//                tv.setText(resultCode+message);
//            }

        }
    }
}
