package com.example.objetos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Datos extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario, etTelefono, etFecha;
    Button botonFecha;
    String fechaUser, nomUser, nacionUser, telUser;
    int dia, mes, anio;
    RadioButton rbF, rbM;
    Spinner sp1;
    Intent intentBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        etUsuario = (EditText) findViewById(R.id.nombreUsuario);
        etTelefono = (EditText) findViewById(R.id.phone);


        Button botonSiguiente = (Button) findViewById(R.id.btn_siguiente);
        botonSiguiente.setOnClickListener(this);
        Button botonLimpiar = (Button) findViewById(R.id.btn_limpiar);
        botonLimpiar.setOnClickListener(this);
        botonFecha = (Button) findViewById(R.id.btn_fecha);
        botonFecha.setOnClickListener(this);

        etFecha = (EditText) findViewById(R.id.fechaNacimiento);

        rbF = (RadioButton) findViewById(R.id.sexoF);
        rbM = (RadioButton) findViewById(R.id.sexoM);
        sp1 = (Spinner) findViewById(R.id.nacionalidad);

        String[] opciones = {"Selecciona una opción", "Mexicano", "Extranjero"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, opciones);
        sp1.setAdapter(adapter);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        intentBienvenido = new Intent(this, Bienvenido.class);

        switch (view.getId()){
            case R.id.btn_fecha:
                fecha(view);
                break;

            case R.id.btn_siguiente:
                enviarDatos();
                startActivity(intentBienvenido);
                Toast.makeText(this, "Abriendo la tercer actividad", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_limpiar:
                etUsuario.setText("");
                etFecha.setText("");
                etTelefono.setText("");
                rbF.setChecked(false);
                rbM.setChecked(false);
                sp1.setSelection(0);
                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void fecha(View view) {
        if (view == botonFecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    etFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            },anio,mes,dia);
            datePickerDialog.show();
        }

    }

    public void enviarDatos() {
        intentBienvenido.putExtra("mjs",etUsuario.getText().toString());
        intentBienvenido.putExtra("mNacion",sp1.getSelectedItem().toString());
        intentBienvenido.putExtra("mEdad",etFecha.getText().toString());
        intentBienvenido.putExtra("mTel",etTelefono.getText().toString());
    }


}
