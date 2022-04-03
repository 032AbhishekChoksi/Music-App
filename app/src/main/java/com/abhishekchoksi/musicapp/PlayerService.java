package com.abhishekchoksi.musicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PlayerService extends Service {

    MediaPlayer mp;
    public PlayerService() {
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service was Created", Toast.LENGTH_SHORT).show();

        mp = MediaPlayer.create(getApplicationContext(),R.raw.myaudio);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }
}
