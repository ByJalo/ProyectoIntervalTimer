package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionEjercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_ejercicio);

        SeekBar barraEjercicio = (SeekBar) findViewById(R.id.seekBarEjercicio);
        barraEjercicio.setMax(120);
        EditText Descanso = (EditText) findViewById(R.id.Ejercicio);
        Descanso.setText("60");
        barraEjercicio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraEjercicio;
                i = bar.getProgress();
                Descanso.setText(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {}
            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });
        Descanso.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i<barraEjercicio.getMax() && i>0){
                    barraEjercicio.setProgress(i);
                }
                if(i>barraEjercicio.getMax()){
                    barraEjercicio.setProgress(120);
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}
