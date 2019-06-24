package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ImagesActivity extends AppCompatActivity implements ImagesFragment.OnListFragmentInteractionListener, View.OnClickListener {


    Button next,back;
    Intent intentComunication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);




        next=findViewById(R.id.btn_img_next);
        back=findViewById(R.id.btn_img_back);
        next.setOnClickListener(this);
        back.setOnClickListener(this);



    }

    @Override
    public void onListFragmentInteraction(Images item) {

    }

    @Override
    public void onClick(View view) {


        switch (view.getId())
        {

            case R.id.btn_img_back:


                break;
            case R.id.btn_img_next:

                intentComunication = new Intent(this, CameraActivity.class);
                startActivity(intentComunication);
                finish();
                break;
        }

    }
}
