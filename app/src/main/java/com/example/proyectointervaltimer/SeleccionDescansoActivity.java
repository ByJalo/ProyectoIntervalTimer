package com.example.proyectointervaltimer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionDescansoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_descanso);

        SeekBar barraDescanso = (SeekBar) findViewById(R.id.seekBarDescanso);
        barraDescanso.setMax(120);

        TextView textoDescanso = (TextView) findViewById(R.id.Descanso);
        textoDescanso.setText("60");

        barraDescanso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int descanso = 1;

            @Override
            public void onProgressChanged(SeekBar bar, int i, boolean b) {
                descanso = i;
                textoDescanso.setText(String.valueOf(descanso));
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {
                textoDescanso.setText(String.valueOf(descanso));
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                textoDescanso.setText(String.valueOf(descanso));
            }
        });

        textoDescanso.addTextChangedListener(new TextWatcher() {
            int descanso = 1;
            public void afterTextChanged(Editable s) {
                try{
                    descanso = Integer.parseInt(s.toString());
                }catch (NumberFormatException e) {
                    descanso = 1;
                }
                barraDescanso.setProgress(descanso);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try{
                    descanso = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    descanso = 1;
                }
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    descanso = Integer.parseInt(s.toString());
                }catch (NumberFormatException e){
                    descanso = 1;
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        // Prepare the data to be sent back to the first activity
        super.onBackPressed();

        int timeout = Integer.parseInt(((EditText) findViewById(R.id.Trabajo)).getText().toString());

        Intent mainAct = new Intent(SeleccionDescansoActivity.this, MainActivity.class);
        mainAct.putExtra("timeout", timeout);


        // Finish the activity
        startActivity(mainAct);
    }
}
