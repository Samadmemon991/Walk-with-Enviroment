package com.capstone.objdetection;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Process;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ProgressBar;

import com.capstone.objdetection.env.Logger;

import java.util.HashMap;
import java.util.Locale;

public class end extends AppCompatActivity {
    ProgressBar pg;
    TextToSpeech tts;
    HashMap<String, String> mapE = new HashMap<String, String>();
    CountDownTimer cdt;
    Intent toDetector;
    private static final Logger LOGGER = new Logger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().hide();

        toDetector = new Intent(this, DetectorActivity.class);
        toDetector.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        mapE.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueIDE");
        pg = findViewById(R.id.progBar);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.US);
                    tts.setSpeechRate(0.9f);
                    LOGGER.d("tts Status: Success");
                    int res = tts.speak("To Re-scan the Environment\n touch anywhere on screen in 5 seconds", TextToSpeech.QUEUE_FLUSH, mapE);
                    LOGGER.d("result TTS = " + res);
                }
            }
        });

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {
                LOGGER.d("Started tts");
            }

            @Override
            public void onDone(String s) {
                LOGGER.d("tts onDone: timerStarted");
                runOnUiThread(new Runnable() {
                    public void run() {
                        startTimer();
                    }
                });
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int ttsStopRes = 1;
                        if (tts != null) {
                            ttsStopRes = tts.stop();
                            tts.shutdown();
                        }
                        LOGGER.d("In BG thread: ttsStopRes = " + ttsStopRes);
                    }
                }).start();

            }

            @Override
            public void onError(String s) {}
        });

    }

    void startTimer() {
        LOGGER.d("StartTimer: ");
        cdt = new CountDownTimer(5 * 1000, 50) {
            @Override
            public void onTick(long l) {

                int x = (int) l * 2 / 100;
//                LOGGER.d("onTick: " + x);
                pg.setProgress(x);
            }

            @Override
            public void onFinish() {
                LOGGER.d("onFinish: killing app");
                System.exit(0);
            }
        };
        cdt.start();
        LOGGER.d("CDT started");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LOGGER.d("onTouchEvent: ");
        if (cdt != null)
            cdt.cancel();
        LOGGER.d("cdt cancel ");
        startActivity(toDetector);
        finish();
        LOGGER.d("Activity finish");
        return super.onTouchEvent(event);
    }

}