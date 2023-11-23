package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        EditText trabajo = (EditText) findViewById(R.id.Trabajo);


        barraTrabajo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraTrabajo;
                i = bar.getProgress();
                trabajo.setText(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        trabajo.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i<barraTrabajo.getMax() && i>0){
                    barraTrabajo.setProgress(i);
                }
                if(i>barraTrabajo.getMax()){
                    barraTrabajo.setProgress(barraTrabajo.getMax());
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}
