package com.example.broadcastintent;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        configureReceiver();
    }
    public void sendBroadcast(View v){
        Intent i =new Intent();
        i.setAction("  com. example.broadcastintent");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }
    private void configureReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction("  com. example.broadcastintent");
        receiver= new MyReceiver();
        registerReceiver(receiver,filter);
    }
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}