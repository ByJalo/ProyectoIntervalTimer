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

        EditText textoRondas = (EditText) findViewById(R.id.Rondas);
        textoRondas.setText("1");

        barraRondas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rondas = 1;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rondas = progress;
                textoRondas.setText(String.valueOf(rondas));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textoRondas.setText(String.valueOf(rondas));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textoRondas.setText(String.valueOf(rondas));
            }
        });

        textoRondas.addTextChangedListener(new TextWatcher() {
            int rondas = 1;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    rondas = Integer.parseInt(s.toString());
                } catch (NumberFormatException e) {
                    rondas = 1;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    rondas = Integer.parseInt(s.toString());
                } catch (NumberFormatException e) {
                    rondas = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    rondas = Integer.parseInt(s.toString());
                } catch (NumberFormatException e) {
                    rondas = 1;
                }
                barraRondas.setProgress(rondas);
            }
        });

    }
}
