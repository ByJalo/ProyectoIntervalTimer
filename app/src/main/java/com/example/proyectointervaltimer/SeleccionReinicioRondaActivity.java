package com.example.proyectointervaltimer;

import android.content.Intent;
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

        EditText textoReinicioRonda = (EditText) findViewById(R.id.reinicioRonda);
        textoReinicioRonda.setText("60");
        barraReinicioRonda.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int reinicioRonda = 1;
            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                reinicioRonda = i;
                textoReinicioRonda.setText(String.valueOf(reinicioRonda));
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {
                textoReinicioRonda.setText(String.valueOf(reinicioRonda));
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                textoReinicioRonda.setText(String.valueOf(reinicioRonda));
            }
        });
        textoReinicioRonda.addTextChangedListener(new TextWatcher() {
            int reinicioRonda = 1;
            public void afterTextChanged(Editable s) {
                try{
                    reinicioRonda = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    reinicioRonda = 1;
                }
                barraReinicioRonda.setProgress(reinicioRonda);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try{
                    reinicioRonda = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    reinicioRonda = 1;
                }

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    reinicioRonda = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    reinicioRonda = 1;
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Prepare the data to be sent back to the first activity
        super.onBackPressed();

        int round_reset = Integer.parseInt(((EditText) findViewById(R.id.Trabajo)).getText().toString());

        Intent mainAct = new Intent(SeleccionReinicioRondaActivity.this, MainActivity.class);
        mainAct.putExtra("round_reset", round_reset);


        // Finish the activity
        startActivity(mainAct);
    }
}
