package com.example.imageviewgc;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import  android.view.View;
import android.media.MediaPlayer;
import android.widget.VideoView;
import android.widget.MediaController;
import android.net.Uri;


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
    public void PlayMusic(View view){
        MediaPlayer ring=MediaPlayer.create(MainActivity.this,R.raw.avengers);
        ring.start();
    }
    public void PlayVideo(View view){
        VideoView v=findViewById(R.id.videoView);
        v.setVideoPath("android.resource://" + getPackageName() + "/"+R.raw.ironman);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(v);
        mc.setMediaPlayer(v);
        v.setMediaController(mc);
        v.start();
    }
}