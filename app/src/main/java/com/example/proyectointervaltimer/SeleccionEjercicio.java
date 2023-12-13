package com.example.proyectointervaltimer;

import android.content.Intent;
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
        barraEjercicio.setMax(10);

        EditText textoEjercicio = (EditText) findViewById(R.id.Ejercicio);
        textoEjercicio.setText("5");

        barraEjercicio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int ejercicio = 1;
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                ejercicio = i;
                textoEjercicio.setText(String.valueOf(ejercicio));
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {
                textoEjercicio.setText(String.valueOf(ejercicio));
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                textoEjercicio.setText(String.valueOf(ejercicio));
            }
        });
        textoEjercicio.addTextChangedListener(new TextWatcher() {
            int ejercicio = 1;

            public void afterTextChanged(Editable s) {
                try {
                    ejercicio = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    ejercicio = 1;
                }
                barraEjercicio.setProgress(ejercicio);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    ejercicio = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    ejercicio = 1;
                }
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    ejercicio = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    ejercicio = 1;
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Prepare the data to be sent back to the first activity
        super.onBackPressed();

        int work_time = Integer.parseInt(((EditText) findViewById(R.id.Trabajo)).getText().toString());

        Intent mainAct = new Intent(SeleccionEjercicio.this, MainActivity.class);
        mainAct.putExtra("work_time", work_time);


        // Finish the activity
        startActivity(mainAct);
    }
}
