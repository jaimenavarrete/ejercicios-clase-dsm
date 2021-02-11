package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class proceso extends AppCompatActivity {

    private TextView numeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso);
        numeros=(TextView)findViewById(R.id.n1);
        Bundle bundle = getIntent().getExtras();
        String numero=bundle.getString("txtNumero");
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n2);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n3);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n4);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n5);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n6);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n7);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n8);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n9);
        numeros.setText(numero);
        numeros=(TextView)findViewById(R.id.n10);
        numeros.setText(numero);
        int res=0;
        for (int i=1; i<=10; i++){

            res=  (Integer.parseInt(numero))*i;
            switch (i){
                case 1:
                    numeros=(TextView)findViewById(R.id.r1);
                    numeros.setText(Integer.toString(res));
                    break;
                case 2:
                    numeros=(TextView)findViewById(R.id.r2);
                    numeros.setText(Integer.toString(res));
                    break;
                case 3:
                    numeros=(TextView)findViewById(R.id.r3);
                    numeros.setText(Integer.toString(res));
                    break;
                case 4:
                    numeros=(TextView)findViewById(R.id.r4);
                    numeros.setText(Integer.toString(res));
                    break;
                case 5:
                    numeros=(TextView)findViewById(R.id.r5);
                    numeros.setText(Integer.toString(res));
                    break;
                case 6:
                    numeros=(TextView)findViewById(R.id.r6);
                    numeros.setText(Integer.toString(res));
                    break;
                case 7:
                    numeros=(TextView)findViewById(R.id.r7);
                    numeros.setText(Integer.toString(res));
                    break;
                case 8:
                    numeros=(TextView)findViewById(R.id.r8);
                    numeros.setText(Integer.toString(res));
                    break;
                case 9:
                    numeros=(TextView)findViewById(R.id.r9);
                    numeros.setText(Integer.toString(res));
                    break;
                case 10:
                    numeros=(TextView)findViewById(R.id.r10);
                    numeros.setText(Integer.toString(res));
                    break;
            }

        }

    }
    public void finalizar(View v) {
        finish();
    }
}