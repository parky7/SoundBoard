package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool.OnLoadCompleteListener;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.soundboard.R;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ButtonA;
    private Button ButtonBb;
    private Button ButtonB;
    private Button ButtonC;
    private Button ButtonCc;
    private Button ButtonD;
    private Button ButtonDd;
    private Button ButtonE;
    private Button ButtonF;
    private Button ButtonFf;
    private Button ButtonG;
    private Button ButtonGg;
    private Button Scale;
    private Button thousandMiles;
    private NumberPicker notes;
    private NumberPicker amount;
    private Button playNP;
    private int[] notesArray;


    private SoundPool soundPool;
    private boolean isSoundPoolLoaded;
    private int aNote;
    private int bbNote;
    private int bNote;
    private int cNote;
    private int ccNote;
    private int dNote;
    private int ddNote;
    private int eNote;
    private int fNote;
    private int ffNote;
    private int gNote;
    private int ggNote;
    private Chord aMinor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        intializeSoundPool();
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        wireWidgets();
        aMinor = new Chord(new int[]{aNote, cNote, eNote});
        notes.setMaxValue(12);
        notes.setMinValue(1);
        notes.setDisplayedValues(new String[]{"A", "B", "B♭", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"});
        amount.setMinValue(1);
        amount.setMaxValue(8);
        amount.setDisplayedValues(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"});
        setListners();
        notesArray = new int[]{aNote, bNote, cNote, ccNote, dNote, ddNote, eNote, fNote, ffNote, gNote, ggNote};
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                isSoundPoolLoaded = true;
            }
        });


        // Load the sound

    }
    private void playChord(Chord chord){
        for(int note: chord.getNotes()){
            soundPool.play(note, 1, 1, 1, 0, 1f);
        }
    }


    private void intializeSoundPool() {
        aNote = soundPool.load(this, R.raw.scalea, 1);
        bbNote = soundPool.load(this, R.raw.scalebb, 1);
        bNote = soundPool.load(this, R.raw.scaleb, 1);
        cNote = soundPool.load(this, R.raw.scalec, 1);
        ccNote = soundPool.load(this, R.raw.scalecs, 1);
        dNote = soundPool.load(this, R.raw.scaled, 1);
        ddNote = soundPool.load(this, R.raw.scaleds, 1);
        eNote = soundPool.load(this, R.raw.scalee, 1);
        fNote = soundPool.load(this, R.raw.scalef, 1);
        ffNote = soundPool.load(this, R.raw.scalefs, 1);
        gNote = soundPool.load(this, R.raw.scaleg, 1);
        ggNote = soundPool.load(this, R.raw.scalegs, 1);



    }

    private void wireWidgets() {
        ButtonA = findViewById(R.id.button_main_A);
        ButtonBb = findViewById(R.id.button_main_Bb);
        ButtonB = findViewById(R.id.button_main_B);
        ButtonC = findViewById(R.id.button_main_C);
        ButtonCc = findViewById(R.id.button_main_Cc);
        ButtonD = findViewById(R.id.button_main_D);
        ButtonDd = findViewById(R.id.button_main_Dd);
        ButtonE = findViewById(R.id.button_main_E);
        ButtonF = findViewById(R.id.button_main_F);
        ButtonFf = findViewById(R.id.button_main_Ff);
        ButtonG = findViewById(R.id.button_main_G);
        ButtonGg = findViewById(R.id.button_main_Gg);
        Scale = findViewById(R.id.button_main_scale);
        thousandMiles = findViewById(R.id.button_main_thousandMiles);
        notes = findViewById(R.id.numberPicker_main_notes);
        amount = findViewById(R.id.numberPicker_main_amountofTimes);
        playNP = findViewById(R.id.button_main_playNumberPicker);

    }

    private void setListners() {
        ButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(aNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(bNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonBb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(bbNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(cNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ccNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(dNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonDd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ddNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(eNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(fNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ffNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(gNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });
        ButtonGg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ggNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

            }

        });


        Scale.setOnClickListener(this);
        thousandMiles.setOnClickListener(this);
        playNP.setOnClickListener(this);


    }

    private void delay(int millisDelay) {
        try {
            Thread.sleep(millisDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        final float volume = actualVolume / maxVolume;
        switch (view.getId()) {
            case R.id.button_main_scale: {


                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(aNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(bNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                if (isSoundPoolLoaded) {
                    soundPool.play(bbNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(cNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ccNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(dNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ddNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(eNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }


                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(fNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ffNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(gNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }

                delay(1000);

                // Is the sound loaded already?
                if (isSoundPoolLoaded) {
                    soundPool.play(ggNote, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }



                break;
            }
            case R.id.button_main_thousandMiles: {
                if(isSoundPoolLoaded){
                    for(int i =0; i <3; i++) {
                        soundPool.play(cNote, volume, volume, 1, 0, 1f);
                        delay(200);
                        soundPool.play(fNote, volume, volume, 1, 0, 1f);
                        delay(200);
                        soundPool.play(gNote, volume, volume, 1, 0, 1f);
                        delay(200);
                        soundPool.play(cNote, volume, volume, 1, 0, 1f);
                        delay(200);
                        soundPool.play(fNote, volume, volume, 1, 0, 1f);
                        delay(200);
                        soundPool.play(gNote, volume, volume, 1, 0, 1f);
                        delay(380);
                        playChord(aMinor);
                        delay(380);
                        soundPool.play(aNote, volume, volume, 1, 0, 1f);
                        delay(500);
                    }



                }
                break;


            }
            case R.id.button_main_playNumberPicker: {
                if(isSoundPoolLoaded){
                    int currentNote = notesArray[notes.getValue()];
                    for(int i = 0; i < amount.getValue(); i++){
                        soundPool.play(currentNote, volume, volume, 1, 0, 1f);
                        delay(500);
                    }
                }
            }

        }
    }
}