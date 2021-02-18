package com.udb.dsm.desafiolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    TextView txtViewName, txtViewYears, txtViewSalary, txtViewIncrease, txtViewNewSalary;
    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        // Obtener las variables enviadas desde la otra activity y definirlas en esta activity
        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        Double salary = Double.parseDouble(bundle.getString("salary"));
        Integer years = Integer.parseInt(bundle.getString("years"));

        Double increasePercentage = 0.0, increase, newSalary;

        // Asignar los textview a sus variables correspondientes
        txtViewName = findViewById(R.id.txtViewName);
        txtViewYears = findViewById(R.id.txtViewYears);
        txtViewSalary = findViewById(R.id.txtViewSalary);
        txtViewIncrease = findViewById(R.id.txtViewIncrease);
        txtViewNewSalary = findViewById(R.id.txtViewNewSalary);


        // Agregar los valores iniciales en los textview
        txtViewName.setText(name);
        txtViewYears.setText(years+" años");
        txtViewSalary.setText("$ "+salary);


        if(salary < 500 && years >= 10) {
            increasePercentage = 0.2;
        }
        else if(salary < 500 && years < 10){
            increasePercentage = 0.05;
        }

        increase = salary * increasePercentage;
        newSalary = salary + increase;

        // Agregar los nuevos valores en los textview
        txtViewIncrease.setText("$ " + increase + " (" + increasePercentage * 100 + "%)");
        txtViewNewSalary.setText("$ "+newSalary);


        // Agregar boton de retorno hacia la otra activity
        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        
        
    }
}