package com.example.notification;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.renderscript.RenderScript;
import android.view.View;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import android.os.Build;


public class MainActivity extends AppCompatActivity {
private static String CHANNEL_ID="example_channel";
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
        createChannel();
    }
    public void createChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            CharSequence name="Example Channel";
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID,name,importance);
            NotificationManager man=getSystemService(NotificationManager.class);
            man.createNotificationChannel(channel);
        }
    }

    public void naughtyfy(View v){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this,CHANNEL_ID).setSmallIcon(R.drawable.ep_noti).setContentTitle("Hey You!").setContentText("Euphoria is here! Brace for Impact!").setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager man=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        man.notify(1,builder.build());
    }

}