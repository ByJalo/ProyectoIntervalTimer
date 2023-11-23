package com.example.proyectointervaltimer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionReinicioRondaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_reinicioronda);

        SeekBar barraReinicioRonda = (SeekBar) findViewById(R.id.seekBarReinicioronda);
        barraReinicioRonda.setMax(120);
        EditText ReinicioRonda = (EditText) findViewById(R.id.reinicioRonda);
        ReinicioRonda.setText("60");
        barraReinicioRonda.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                bar = barraReinicioRonda;
                i = bar.getProgress();
                ReinicioRonda.setText(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {}
            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });
        ReinicioRonda.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i<barraReinicioRonda.getMax() && i>0){
                    barraReinicioRonda.setProgress(i);
                }
                if(i>barraReinicioRonda.getMax()){
                    barraReinicioRonda.setProgress(120);
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}
