package com.example.proyectointervaltimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CronoTimerActivity extends AppCompatActivity {
    private Button startButton;
    private ProgressBar progressBar;
    private CountDownTimer countDownTimer;
    private TextView textViewTimer;
    private Button buttonStart, buttonStop;

    private long timeLeftInMillis;
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crono_timer);

        startButton = findViewById(R.id.buttonStart);
        progressBar = findViewById(R.id.progressBar);
        textViewTimer = findViewById(R.id.tiempo);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountdown();
            }
        });
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStopTimer();
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }
    private void updateCountDownText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        textViewTimer.setText(timeLeftFormatted);
    }
    private void resetTimer() {
        timeLeftInMillis = 0;
        updateCountDownText();
        buttonStop.setVisibility(View.INVISIBLE);
        buttonStart.setVisibility(View.VISIBLE);
    }
    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        buttonStart.setText("Comenzar");
        buttonStop.setVisibility(View.VISIBLE);
    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                buttonStart.setText("Comenzar");
                buttonStop.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunning = true;
        buttonStart.setText("Pausa");
        buttonStop.setVisibility(View.VISIBLE);
    }

    private void startStopTimer() {
        if (timerRunning) {
            pauseTimer();
        } else {
            startTimer();
        }
    }
    private void startCountdown() {
        countDownTimer = new CountDownTimer(10000, 100) { // 10 segundos (10000 milisegundos) con actualización cada 100ms
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished / 100); // Actualizar la ProgressBar
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
                // Aquí puedes activar la cuenta u realizar otras acciones al finalizar el conteo.
            }
        };
        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}

