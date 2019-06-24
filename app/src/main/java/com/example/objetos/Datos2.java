package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Datos2 extends AppCompatActivity implements View.OnClickListener {
    Button botonFecha;
    int dia, mes, anio;
    EditText etFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos2);
        botonFecha = (Button) findViewById(R.id.btn_fecha);

        botonFecha.setOnClickListener(this);

        etFecha = (EditText) findViewById(R.id.fechaNacimiento);


    }

    @Override
    public void onClick(View view) {
        if (view == botonFecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfYear) {
                    etFecha.setText(dayOfYear + "/" + (monthOfYear + 1) + "/" + year);
                }
            },
                    anio, mes, dia);
            datePickerDialog.show();
        }
    }
}
