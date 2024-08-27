package com.example.broadcast;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureReceiver();
    }

    public void sendBroadcast(View v) {
        Intent i = new Intent();
        i.setAction("com.example.broadcast").setPackage(getPackageName());
        sendBroadcast(i);
    }

    private void configureReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.broadcast");
        receiver = new MyReceiver();
        registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
