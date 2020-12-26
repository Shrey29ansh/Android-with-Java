package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    TimerTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        task = new nextActivity();
        timer.schedule(task,3000);
    }
    class nextActivity extends TimerTask{
        private static final String TAG = "MyActivity";
        public void run(){
            Intent intent = new Intent(MainActivity.this, MainScreen.class);
            startActivity(intent);
            finish();
            timer.cancel();
        }
    }

}