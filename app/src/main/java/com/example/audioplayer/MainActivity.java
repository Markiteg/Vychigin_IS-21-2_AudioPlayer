package com.example.audioplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button playButton, pauseButton;
    SeekBar volumeControl;
    AudioManager audioManager;
    Boolean IsPause = false;

    private
    Button  firstAudioButton, secondAudioButton, thirdAudioButton, fourAudioButton, fiveAudioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        firstAudioButton = findViewById(R.id.firstAudio);
        secondAudioButton = findViewById(R.id.secondAudio);
        thirdAudioButton = findViewById(R.id.thirdAudio);
        fourAudioButton = findViewById(R.id.fourAudio);
        fiveAudioButton = findViewById(R.id.fiveAudio);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeControl = findViewById(R.id.volumeControl);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curValue);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        pauseButton.setEnabled(false);
    }

    private void stopPlay() {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        pauseButton.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            playButton.setEnabled(true);
            firstAudioButton.setEnabled(true);
            secondAudioButton.setEnabled(true);
            thirdAudioButton.setEnabled(true);
            fourAudioButton.setEnabled(true);
            fiveAudioButton.setEnabled(true);

        } catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view) {
        if (mPlayer != null) {
            mPlayer.start();
            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
        }
    }

    public void pause(View view) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            firstAudioButton.setEnabled(true);
            secondAudioButton.setEnabled(true);
            thirdAudioButton.setEnabled(true);
            fourAudioButton.setEnabled(true);
            fiveAudioButton.setEnabled(true);
            IsPause = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) {
            stopPlay();
        }
    }

    public void firstAudio(View view) {
        if (IsPause)
            mPlayer.start();
        stopPlay();
        mPlayer = MediaPlayer.create(this, R.raw.stereomednes);
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);

    }

    public void secondAudio(View view) {
        if (IsPause)
            mPlayer.start();
        stopPlay();
        mPlayer = MediaPlayer.create(this, R.raw.atthespeedoflight);
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
    }

    public void thirdAudio(View view) {
        if (IsPause)
            mPlayer.start();
        stopPlay();
        mPlayer = MediaPlayer.create(this, R.raw.deadlocked);
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
    }

    public void fourAudio(View view) {
        if (IsPause)
            mPlayer.start();
        stopPlay();
        mPlayer = MediaPlayer.create(this, R.raw.electrodinamix);
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
    }

    public void fiveAudio(View view) {
        if (IsPause)
            mPlayer.start();
        stopPlay();
        mPlayer = MediaPlayer.create(this, R.raw.canage);
        mPlayer.start();
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
    }
}
