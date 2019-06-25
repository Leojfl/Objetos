package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreditosActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonSig, botonAnt;
    TextView tvCreditos;

    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        botonSig = (Button) findViewById(R.id.btns_sig);
        botonSig.setOnClickListener(this);
        botonAnt =(Button) findViewById(R.id.btns_ant);
        botonAnt.setOnClickListener(this);

        tvCreditos = (TextView) findViewById(R.id.textCreditos);

        tvCreditos.setText("Sandra Flores Contreras\nLeonardo Jesús Flores López\nM. en C. Rocío Elizabeth Pulido Alba");
    }

    @Override
    public void onClick(View view) {
        in = new Intent(this, ImagesActivity.class);

        switch (view.getId()){
            case R.id.btns_sig:
                startActivity(in);
                Toast.makeText(this, "Img", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btns_ant:
                finish();
                break;
        }
    }
}
