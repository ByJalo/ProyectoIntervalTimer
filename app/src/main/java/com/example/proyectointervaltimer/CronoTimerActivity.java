package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class CronoTimerActivity extends AppCompatActivity {
    private Button pausa;
    private ProgressBar progressBar;
    private CountDownTimer cuentaAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crono_timer);

        pausa = findViewById(R.id.pausa);
        progressBar = findViewById(R.id.progressBar);

        pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmpezarCuentaAtras();
            }
        });

    }

    private void EmpezarCuentaAtras() {
        cuentaAtras = new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progreso = (int) (millisUntilFinished / 100);
                progressBar.setProgress(progreso);

            }

            @Override
            public void onFinish() {

                progressBar.setProgress(0);

            }
        };
        cuentaAtras.start();
        
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cuentaAtras != null) {
            cuentaAtras.cancel();
        }
    }
}
