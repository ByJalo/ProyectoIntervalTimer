package com.example.proyectointervaltimer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
        EditText textoTrabajo = (EditText) findViewById(R.id.Trabajo);
        textoTrabajo.setText("30");

        barraTrabajo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int trabajo = 1;
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                trabajo = i;
                textoTrabajo.setText(String.valueOf(trabajo));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textoTrabajo.setText(String.valueOf(trabajo));
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textoTrabajo.setText(String.valueOf(trabajo));
            }
        });

        textoTrabajo.addTextChangedListener(new TextWatcher() {
            int trabajo = 1;
            public void afterTextChanged(Editable s) {
                try {
                    trabajo = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    trabajo = 1;
                }
                barraTrabajo.setProgress(trabajo);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    trabajo = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    trabajo = 1;
                }
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    trabajo = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    trabajo = 1;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Prepare the data to be sent back to the first activity
        super.onBackPressed();

        int workTime = Integer.parseInt(((EditText) findViewById(R.id.Trabajo)).getText().toString());

        Intent mainAct = new Intent(SeleccionTrabajoActivity.this, MainActivity.class);
        mainAct.putExtra("work_time", workTime);

        Log.println(Log.INFO, "work_time", String.valueOf(workTime));

        // Finish the activity
        startActivity(mainAct);
    }
}
