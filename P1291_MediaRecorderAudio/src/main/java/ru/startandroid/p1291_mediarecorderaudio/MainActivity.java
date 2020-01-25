package ru.startandroid.p1291_mediarecorderaudio;

import android.support.v7.app.AppCompatActivity;
import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = Environment.getExternalStorageDirectory() + "/record.3gpp";
    }

    public void recordStart(View v) {
        try {
            releaseRecorder();

            File outFile = new File(fileName);
            if (outFile.exists()) {
                outFile.delete();
            }

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(fileName);
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void recordStop(View v) {
        if (mediaRecorder != null) {
            mediaRecorder.stop();
        }
    }

    public void playStart(View v) {
        try {
            releasePlayer();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fileName);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playStop(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void releaseRecorder() {
        if (mediaRecorder != null) {
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

    private void releasePlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
        releaseRecorder();
    }

}
/*
Распишу еще несколько интересных методов.

setAudioChannels – можно задать режим записи 1 (моно) или 2 (стерео)

setAudioEncodingBitRate и setAudioSamplingRate задают соответственно битрейт и сэмплрейт. Если опять же вкратце, то битрейт – это насколько качественно пишется звук, сэмплрейт – как часто считываются данные с микрофона. Подробности можно узнать у гугла.

setMaxDuration позволяет указать максимальную длительность записи. По достижении этого времени (в мсек), запись остановится, а слушатель, указанный в MediaRecorder.OnInfoListener, получит код what =  MEDIA_RECORDER_INFO_MAX_DURATION_REACHED.

setMaxFileSize позволяет указать максимальный размер файла. По достижении указанного размера (в байтах), запись остановится, а слушатель, указанный в MediaRecorder.OnInfoListener, получит код what =  MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED.

Разумеется, эти методы надо вызывать перед вызовом prepare
 */