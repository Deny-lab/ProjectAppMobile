package com.deny.projectappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView btnLogin = findViewById(R.id.btn_login_log);
        btnLogin.setOnClickListener(this);

        ImageView btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login_log){
            Intent moveLogin = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(moveLogin);
        } else if (v.getId() == R.id.btn_create) {
            Intent moveCreate =  new Intent(LoginActivity.this, CreateAccActivity.class);
            startActivity(moveCreate);
        }
    }
}