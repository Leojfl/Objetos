package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        tvBienvenido = (TextView) findViewById(R.id.bienvenido);
        tvNacion = (TextView) findViewById(R.id.nacionalidad);
        tvEdad = (TextView) findViewById(R.id.edad);
        tvTel = (TextView) findViewById(R.id.telefono);

        obtnerDatos();


    }

    @Override
    public void onClick(View view) {
        //i_menu = new Intent(this, MenuActivity.class);
        s


    }

    public void obtnerDatos() {
        Bundle extras = getIntent().getExtras();
        sBienvenido = extras.getString("mjs", "No aplica");
        sNacion = extras.getString("mNacion","Err 2");
        sEdad = extras.getString("mEdad","Err3");
        sTel = extras.getString("mTel","Err4");
    }


}
