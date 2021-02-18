package com.udb.dsm.desafiolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarDatos extends AppCompatActivity {

    TextView txtViewName, txtViewSalary, txtViewYears;
    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String salary = bundle.getString("salary");
        String years = bundle.getString("years");

        //variable que convierte el numero viniente en double
        double salDouble = Double.parseDouble(salary);
        int anios = Integer.parseInt(years);
        double newSalary;

        if(salDouble < 500 && anios >= 10){
            newSalary = salDouble + (salDouble * 0.2);
        }
        else if( salDouble < 500 && anios < 10){
            newSalary = salDouble + (salDouble * 0.05);
        }
        else{
            newSalary = salDouble;
        }

        txtViewName = findViewById(R.id.txtViewName);
        txtViewSalary = findViewById(R.id.txtViewSalary);
        txtViewYears = findViewById(R.id.txtViewYears);

        txtViewName.setText(name);
        //de ser necesario agregar otr textView para agregar el salario anterior a el aumento
        txtViewSalary.setText(newSalary);
        txtViewYears.setText(years);
        
        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener((v) -> {
//            Toast toastMessage = Toast.makeText(this,"Datos recibidos",Toast.LENGTH_LONG);
//            toastMessage.show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        
        
    }
}