package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionTrabajoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_trabajo);

        SeekBar barraTrabajo = (SeekBar) findViewById(R.id.seekBarTrabajo);
        barraTrabajo.setMax(180);
        EditText rondas = (EditText) findViewById(R.id.Trabajo);

        barraTrabajo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraTrabajo;
                i = bar.getProgress();
                rondas.setText(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
}
