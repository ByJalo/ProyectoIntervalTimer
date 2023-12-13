package com.example.proyectointervaltimer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btncronotimer = findViewById(R.id.btncronotimer);
        Button btntrabajo = findViewById(R.id.btntrabajo);
        Button btndescanso = findViewById(R.id.btndescanso);
        Button btnejercicio = findViewById(R.id.btnejercicio);
        Button btnrondas = findViewById(R.id.btnrondas);
        Button btnreinicioronda = findViewById(R.id.btnreinicioronda);

        btncronotimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cronotimer = new Intent(MainActivity.this, CronoTimerActivity.class);


                int work_time = getIntent().getIntExtra("work_time", 60);
                int timeout = getIntent().getIntExtra("timeout", 15);
                int iterations = getIntent().getIntExtra("iterations", 3);
                int rounds = getIntent().getIntExtra("rounds", 1);
                int round_reset = getIntent().getIntExtra("round_reset", 0);

                Log.println(Log.INFO, "work_time", String.valueOf(work_time));
                Log.println(Log.INFO, "timeout", String.valueOf(timeout));
                Log.println(Log.INFO, "iterations", String.valueOf(iterations));
                Log.println(Log.INFO, "rounds", String.valueOf(rounds));
                Log.println(Log.INFO, "round_reset", String.valueOf(round_reset));

                startActivity(cronotimer);
            }
        });

        btntrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trabajo = new Intent(MainActivity.this, SeleccionTrabajoActivity.class);

                startActivity(trabajo);
            }
        });

        btndescanso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent descanso = new Intent(MainActivity.this, SeleccionDescansoActivity.class);

                startActivity(descanso);
            }
        });

        btnejercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ejercicio = new Intent(MainActivity.this, SeleccionEjercicio.class);

                startActivity(ejercicio);
            }
        });

        btnrondas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rondas = new Intent(MainActivity.this, SeleccionRondasActivity.class);

                startActivity(rondas);
            }
        });

        btnreinicioronda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reiniciorondas = new Intent(MainActivity.this, SeleccionReinicioRondaActivity.class);

                startActivity(reiniciorondas);
            }
        });



    }



}

