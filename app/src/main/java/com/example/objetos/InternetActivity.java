package com.example.objetos;

import androidx.appcompat.app.AppCompatActivity;

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
    Button btnSearch;
    TextInputLayout txtUrl;
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

        btnSearch.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String text=txtUrl.getEditText().getText().toString();
        webView.loadUrl(text);

    }
}
