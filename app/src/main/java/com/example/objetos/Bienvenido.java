package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bienvenido extends AppCompatActivity implements View.OnClickListener {
    TextView tvBienvenido, tvNacion, tvEdad, tvTel;
    Button botonSig, botonAnterior;

    String sBienvenido, sNacion, sEdad, sTel;
    Intent i_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        botonSig = findViewById(R.id.btn_siguiente);
        botonSig.setOnClickListener(this);
        botonAnterior = findViewById(R.id.btn_anterior);
        botonAnterior.setOnClickListener(this);

        tvBienvenido = (TextView) findViewById(R.id.bienvenido);
        tvNacion = (TextView) findViewById(R.id.nacionalidad);
        tvEdad = (TextView) findViewById(R.id.edad);
        tvTel = (TextView) findViewById(R.id.telefono);


        obtnerDatos();

        tvBienvenido.setText(sBienvenido);
        tvNacion.setText(sNacion);
        tvTel.setText(sTel);
        tvEdad.setText(edadReal()+"");


    }

    @Override
    public void onClick(View view) {
        i_menu = new Intent(this, MenuActivity.class);

        switch (view.getId()){
            case R.id.btn_siguiente:
                startActivity(i_menu);
                Toast.makeText(this, "Actividad Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_anterior:
                finish();
                break;
        }

    }

    public void obtnerDatos() {
        Bundle extras = getIntent().getExtras();
        sBienvenido = extras.getString("mjs", "No aplica");
        sNacion = extras.getString("mNacion","Err 2");
        sEdad = extras.getString("mEdad","Err3");
        sTel = extras.getString("mTel","Err4");
    }

    public int edadReal() {
        String[] fecha_nacimiento = (sEdad.toString().split("/"));
        int dia = Integer.parseInt(fecha_nacimiento[0]);
        int mes = Integer.parseInt(fecha_nacimiento[1]);
        int año = Integer.parseInt(fecha_nacimiento[2]);
        Calendar edad = new GregorianCalendar(año, mes, dia);
        Calendar hoy = Calendar.getInstance();
        int años = hoy.get(Calendar.YEAR) - edad.get(Calendar.YEAR);
        edad.add(Calendar.YEAR, años);
        if (hoy.before(edad)) {
            años--;
        }
        return años;
    }


}
