package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CronoTimerActivity extends AppCompatActivity {
    private Button btnStartPause, btnReset;
    private TextView tvTimer;

    private Handler handler;
    private boolean timerRunning;
    private long startTime, elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crono_timer);

        btnStartPause = findViewById(R.id.btnStartPause);
        btnReset = findViewById(R.id.btnReset);
        tvTimer = findViewById(R.id.tvTimer);

        handler = new Handler();

        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPauseTimer();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startPauseTimer() {
        if (timerRunning) {
            pauseTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer() {
        startTime = SystemClock.uptimeMillis() - elapsedTime;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                elapsedTime = SystemClock.uptimeMillis() - startTime;
                updateCountUpText(elapsedTime);
                handler.postDelayed(this, 1000);
            }
        }, 1000);

        timerRunning = true;
        btnStartPause.setText("Pause");
    }

    private void pauseTimer() {
        handler.removeCallbacksAndMessages(null);
        timerRunning = false;
        btnStartPause.setText("Start");
    }

    private void resetTimer() {
        handler.removeCallbacksAndMessages(null);
        timerRunning = false;
        btnStartPause.setText("Start");
        elapsedTime = 0;
        updateCountUpText(elapsedTime);
    }

    private void updateCountUpText(long elapsedTime) {
        int seconds = (int) (elapsedTime / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;

        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        tvTimer.setText(timeFormatted);
    }
}
