package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class CronoTimerActivity extends AppCompatActivity {
    private Button pausa, resume;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crono_timer);

        resume = findViewById(R.id.resume);
        pausa = findViewById(R.id.pause);
        progressBar = (android.widget.ProgressBar) findViewById(R.id.progressBar);

        int work_time = getIntent().getIntExtra("work_time", 0);
        int timeout = getIntent().getIntExtra("timeout", 0);
        int iterations = getIntent().getIntExtra("iterations", 0);
        int rounds = getIntent().getIntExtra("rounds", 0);
        int round_reset = getIntent().getIntExtra("round_reset", 0);

        work_time = 10;
        timeout = 5;
        iterations = 2;
        rounds = 2;
        round_reset = 5;

    }

}
