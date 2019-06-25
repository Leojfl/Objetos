package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Intent i_info;
    EditText etUser, etPass;
    String sUser, sPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.btn_aceptar);
        btn.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.btn_cancelar);
        btn2.setOnClickListener(this);

        etUser = (EditText) findViewById(R.id.usuario);
        etPass = (EditText) findViewById(R.id.contraseña);
    }

    @Override
    public void onClick(View view) {
        i_info = new Intent(this, Datos.class);
        switch (view.getId()) {
            case R.id.btn_aceptar:
                sUser = etUser.getText().toString();
                sPass = etPass.getText().toString();
                if (validaLogin(sUser) && validaLogin(sPass)) {
                    Toast.makeText(this, "Abriendo actividad: Datos Generales.", Toast.LENGTH_SHORT).show();
                    startActivity(i_info);
                } else {
                    Toast.makeText(this, "Verifica tus datos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar:
                Toast.makeText(this, "Saliendo.", Toast.LENGTH_SHORT).show();
                System.exit(0);
                break;
        }
    }

    public boolean validaLogin(String cadena) {
        return cadena != null && cadena.trim().length() > 0;
    }
}
