package com.example.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
    public void startMedia(View v){
        Intent i=new Intent(MainActivity.this,MediaService.class);
        i.setAction("START");
        startService(i);
    }
    public void stopMedia(View v){
    Intent i=new Intent(MainActivity.this,MediaService.class);
    stopService(i);
    }
    public void pauseMedia(View v){
        Intent i=new Intent(MainActivity.this,MediaService.class);
        i.setAction("PAUSE");
        startService(i);
    }
    public void resumeMedia(View v){
        Intent i=new Intent(MainActivity.this,MediaService.class);
        i.setAction("RESUME");
        startService(i);
    }

}