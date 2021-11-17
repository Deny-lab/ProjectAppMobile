package com.deny.projectappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView btnBack = findViewById(R.id.back_1);
        btnBack.setOnClickListener(this);

        ImageView btnLogin = findViewById(R.id.login_log);
        btnLogin.setOnClickListener(this);

        ImageView btnCreate = findViewById(R.id.create_log);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_1) {
            Intent back = new Intent(LoginActivity.this, LandingActivity.class);
            startActivity(back);
        } else if (v.getId() == R.id.login_log) {
            Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(toMain);
        } else if (v.getId() == R.id.create_log) {
            Intent toCreate = new Intent(LoginActivity.this, CreateAccActivity.class);
            startActivity(toCreate);
        }
    }
}