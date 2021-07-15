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

import java.util.HashMap;
import java.util.Locale;

public class end extends AppCompatActivity {
    ProgressBar pg;
    TextToSpeech tts;
    HashMap<String, String> mapE = new HashMap<String, String>();
    CountDownTimer cdt;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().hide();

        intent = new Intent(this, DetectorActivity.class);
        mapE.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueIDE");
        pg = findViewById(R.id.progBar);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.US);
                    tts.setSpeechRate(0.9f);
                    Log.d("End Class TTS_test", "Success: tts set ");
                    int res = tts.speak("To Re-scan the Environment\n touch anywhere on screen in 5 seconds", TextToSpeech.QUEUE_FLUSH, mapE);
                    Log.d("End ClassTTS_test", "result = TTS E " + res);
                }
            }
        });

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {
                Log.d("End ClassTTS_test", "Started tts");
            }

            @Override
            public void onDone(String s) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        startTimer();
                    }
                });
                Log.d("End ClassTTS_test", "Done E timer on");
            }

            @Override
            public void onError(String s) {
            }
        });

    }

    void startTimer() {
        Log.d("End Class clock", "startTimer: ");
        cdt = new CountDownTimer(5 * 1000, 50) {
            @Override
            public void onTick(long l) {

                int x = (int) l*2 / 100;
                Log.d("End Class clock", "onTick: " + x);
                pg.setProgress(x);
            }

            @Override
            public void onFinish() {
                Log.d("End Class clock", "onFinish: ");
                finish();
            }
        };
        Log.d("End Class clock", "start: ");
        cdt.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startActivity(intent);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}