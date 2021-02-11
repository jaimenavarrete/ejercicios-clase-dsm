package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero=(EditText)findViewById(R.id.txtNumero);
    }
    public void segundaActividad (View v) {
        Intent i = new Intent(this, proceso.class);
        i.putExtra("txtNumero", numero.getText().toString());
        startActivity(i);
    }
}