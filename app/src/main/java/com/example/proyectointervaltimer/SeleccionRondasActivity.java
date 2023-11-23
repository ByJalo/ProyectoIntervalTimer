package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionRondasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_rondas);

        SeekBar barraRondas = (SeekBar) findViewById(R.id.seekBarRondas);
        barraRondas.setMax(30);
        EditText rondas = (EditText) findViewById(R.id.Rondas);

        barraRondas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraRondas;
                i = bar.getProgress();
                rondas.setText(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {

            }
        });
    }
}
