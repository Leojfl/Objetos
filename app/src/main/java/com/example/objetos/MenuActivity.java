package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_images, btn_credits, btn_camera, btn_internet, btn_exit, btn_gps;
    Intent intentComunication;

    private final int REQUEST_ACCESS_FINE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_images = findViewById(R.id.btn_images);
        btn_credits = findViewById(R.id.btn_credits);
        btn_camera = findViewById(R.id.btn_camera);
        btn_internet = findViewById(R.id.btn_internet);
        btn_exit = findViewById(R.id.btn_exit);
        btn_gps = findViewById(R.id.btn_gps);

        btn_images.setOnClickListener(this);
        btn_credits.setOnClickListener(this);
        btn_internet.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_gps.setOnClickListener(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CAMERA},
                REQUEST_ACCESS_FINE
            );


        }


    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "sí preciona", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.btn_camera:
                break;
            case R.id.btn_credits:
                break;
            case R.id.btn_gps:
                intentComunication = new Intent(this, MapsActivity.class);
                startActivity(intentComunication);


                break;
            case R.id.btn_images:

                intentComunication = new Intent(this, ImagesActivity.class);
                startActivity(intentComunication);
                break;
            case R.id.btn_information:
                break;
            case R.id.btn_internet:
                intentComunication = new Intent(this, InternetActivity.class);
                startActivity(intentComunication);

                break;
        }

    }


    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        boolean permission = false;
        for (int x = 0; x < permissions.length; x++) {
            if (grantResults[x] != PackageManager.PERMISSION_GRANTED) {
                permission = false;
                break;

            } else {
                permission = true;
            }
        }


        if (!permission) {
            Toast.makeText(this, "No hay permisos", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}
