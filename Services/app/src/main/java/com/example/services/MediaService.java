package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MediaService extends Service {
    private MediaPlayer player;
    public MediaService() {
    }
    public int onStartCommand(Intent intent, int flags, int startId){
       if(intent!=null){
           String action=intent.getAction();

       if(action!=null){
           switch (action){
               case "START":
                   player=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
                   player.setLooping(true);
                   player.start();
                   break;
               case "PAUSE":
                   if(player!=null && player.isPlaying()){
                       player.pause();
                   }
                   break;
               case "RESUME":
                   if(player!=null && !player.isPlaying()){
                       player.start();
                   }
                    break;
           }
       }
       }
       return START_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        if(player!=null){
            player.release();
            player=null;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}