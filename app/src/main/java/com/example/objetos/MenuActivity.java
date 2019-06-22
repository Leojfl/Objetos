package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_images, btn_credits, btn_camera, btn_internet, btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_images = findViewById(R.id.btn_images);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btn_camera:
                break;
            case R.id.btn_credits:
                break;
            case R.id.btn_gps:
                break;
            case R.id.btn_images:
                break;
            case R.id.btn_information:
                break;
            case R.id.btn_internet:
                break;
        }

    }
}
