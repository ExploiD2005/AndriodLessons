package ru.startandroid.p1271_soundpool;

import android.support.v7.app.AppCompatActivity;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements OnLoadCompleteListener {

    final String LOG_TAG = "myLogs";
    final int MAX_STREAMS = 5;
    //final int MAX_STREAMS = 1;

    SoundPool sp;
    int soundIdShot;
    int soundIdExplosion;


    int streamIDShot;
    int streamIDExplosion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(this);

        soundIdShot = sp.load(this, R.raw.shot, 1);
        Log.d(LOG_TAG, "soundIdShot = " + soundIdShot);

        try {
            soundIdExplosion = sp.load(getAssets().openFd("explosion.ogg"), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(LOG_TAG, "soundIdExplosion = " + soundIdExplosion);

    }

    /*public void onClick(View view) {
        sp.play(soundIdShot, 1, 1, 0, 0, 1);
        sp.play(soundIdExplosion, 1, 1, 0, 0, 1);
    }*/
    /*public void onClick(View view) {
        sp.play(soundIdShot, 0.1f, 1, 0, 0, 1);
        sp.play(soundIdExplosion, 1, 0.1f, 0, 0, 1);
    }*/
    /*public void onClick(View view) {
        sp.play(soundIdShot, 1, 1, 0, 5, 1);
        sp.play(soundIdExplosion, 1, 1, 0, 2, 1);
    }*/
    /*public void onClick(View view) {
        sp.play(soundIdShot, 1, 1, 0, 0, 0.5f);
        sp.play(soundIdExplosion, 1, 1, 0, 0, 2);
    }*/
    /*public void onClick(View view) {
        streamIDShot = sp.play(soundIdShot, 1, 1, 0, 10, 1);
        Log.d(LOG_TAG, "streamIDShot = " + streamIDShot);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        streamIDExplosion = sp.play(soundIdExplosion, 1, 1, 0, 0, 1);
        Log.d(LOG_TAG, "streamIDExplosion = " + streamIDExplosion);
    }*/
    /*public void onClick(View view) {
        streamIDShot = sp.play(soundIdShot, 1, 1, 1, 10, 1);
        Log.d(LOG_TAG, "streamIDShot = " + streamIDShot);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        streamIDExplosion = sp.play(soundIdExplosion, 1, 1, 0, 0, 1);
        Log.d(LOG_TAG, "streamIDExplosion = " + streamIDExplosion);
    }*/
    /*public void onClick(View view) {
        streamIDShot = sp.play(soundIdShot, 1, 1, 0, 9, 1);
        streamIDExplosion = sp.play(soundIdExplosion, 1, 1, 0, 5, 1);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sp.pause(streamIDShot);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sp.resume(streamIDShot);
    }*/
    /*public void onClick(View view) {
        streamIDShot = sp.play(soundIdShot, 1, 1, 0, 9, 1);
        streamIDExplosion = sp.play(soundIdExplosion, 1, 1, 0, 4, 1);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sp.autoPause();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sp.autoResume();
    }*/
    public void onClick(View view) {
        streamIDShot = sp.play(soundIdShot, 1, 0, 0, 9, 1);
        streamIDExplosion = sp.play(soundIdExplosion, 0, 1, 0, 4, 1);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sp.setVolume(streamIDShot, 0, 1);
        sp.setVolume(streamIDExplosion, 1, 0);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        Log.d(LOG_TAG, "onLoadComplete, sampleId = " + sampleId + ", status = " + status);
    }

}