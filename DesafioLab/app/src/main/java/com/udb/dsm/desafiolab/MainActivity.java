package com.udb.dsm.desafiolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtSalary, txtYears;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtSalary = findViewById(R.id.txtSalary);
        txtYears = findViewById(R.id.txtYears);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener((v) -> {
           String name = txtName.getText().toString();
           String salary = txtSalary.getText().toString();
           String years = txtYears.getText().toString();

           if(!name.equals("") && !salary.equals("") && !years.equals("")) {

               if(!isNumeric(salary)) {
                   Toast toastMessage = Toast.makeText(this,"El salario debe ser un valor numérico",Toast.LENGTH_LONG);
                   toastMessage.show();
               }
               else if(Double.parseDouble(salary) < 100.0) {
                   Toast toastMessage = Toast.makeText(this,"El salario debe ser mayor o igual a $100",Toast.LENGTH_LONG);
                   toastMessage.show();
               }
               else if(!isNumeric(years)) {
                   Toast toastMessage = Toast.makeText(this,"Los años deben ser un valor numérico",Toast.LENGTH_LONG);
                   toastMessage.show();
               }
               else if(Double.parseDouble(years) < 0.0) {
                   Toast toastMessage = Toast.makeText(this,"Los años deben ser mayor a cero",Toast.LENGTH_LONG);
                   toastMessage.show();
               }
               else {
                   Intent intent = new Intent(this, ShowData.class);

                   intent.putExtra("name", name);
                   intent.putExtra("salary", salary);
                   intent.putExtra("years", years);

                   startActivity(intent);
               }
           }
           else {
               Toast toastMessage = Toast.makeText(this,"Tiene que rellenar todos los campos",Toast.LENGTH_LONG);
               toastMessage.show();
           }
        });
    }

    public static boolean isNumeric(String string) {
        boolean result;

        try {
            Double.parseDouble(string);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}