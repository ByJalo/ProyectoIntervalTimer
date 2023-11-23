package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionRondasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_rondas);

        SeekBar barraRondas = (SeekBar) findViewById(R.id.seekBarRondas);
        barraRondas.setMax(10);
        EditText rondas = (EditText) findViewById(R.id.Rondas);
        rondas.setText("5");
        barraRondas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraRondas;
                i = bar.getProgress();
                rondas.setText(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {}
            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });
        rondas.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i<barraRondas.getMax() && i>0){
                    barraRondas.setProgress(i);
                }
                if(i>barraRondas.getMax()){
                    barraRondas.setProgress(barraRondas.getMax());
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

    }
}
