package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionDescansoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_descanso);

        SeekBar barraDecanso = (SeekBar) findViewById(R.id.seekBarDescanso);
        barraDecanso.setMax(120);
        EditText Descanso = (EditText) findViewById(R.id.Descanso);
        Descanso.setText("60");
        barraDecanso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraDecanso;
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
                if (i<barraDecanso.getMax() && i>0){
                    barraDecanso.setProgress(i);
                }
                if(i>barraDecanso.getMax()){
                    barraDecanso.setProgress(barraDecanso.getMax());
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}
