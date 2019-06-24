package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class InternetActivity extends AppCompatActivity implements View.OnClickListener {


    WebView webView;
    Button btnSearch,btn_internet_next,btn_internet_back;
    TextInputLayout txtUrl;
    Intent intentComunication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        webView=findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        btnSearch=findViewById(R.id.btn_search_internet);
        txtUrl=findViewById(R.id.textInputLayout2);



        btn_internet_back=findViewById(R.id.btn_internet_back);
        btn_internet_next=findViewById(R.id.btn_internet_next);

        btn_internet_back.setOnClickListener(this);
        btn_internet_next.setOnClickListener(this);
        btnSearch.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_search_internet:
                String text=txtUrl.getEditText().getText().toString();
                webView.loadUrl(text);
                break;
            case R.id.btn_internet_back:
                intentComunication = new Intent(this, CameraActivity.class);
                startActivity(intentComunication);
                finish();

                break;
            case R.id.btn_internet_next:
                intentComunication = new Intent(this, MapsActivity.class);
                startActivity(intentComunication);
                finish();


                break;
        }

    }
}
