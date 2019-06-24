package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class ImagesActivity extends AppCompatActivity implements ImagesFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
    }

    @Override
    public void onListFragmentInteraction(Images item) {

    }
}
