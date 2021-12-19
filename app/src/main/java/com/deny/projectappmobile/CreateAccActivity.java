package com.deny.projectappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class CreateAccActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ImageView btnBack = findViewById(R.id.back_cr);
        btnBack.setOnClickListener(this);

        ImageView btnCreate = findViewById(R.id.create_cr);
        btnCreate.setOnClickListener(this);

        ImageView btnLogin = findViewById(R.id.login_cr);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_cr) {
            Intent toLanding = new Intent(CreateAccActivity.this, LandingActivity.class);
            startActivity(toLanding);
        } else if (v.getId() == R.id.create_cr) {
            Intent toMain = new Intent(CreateAccActivity.this, MainActivity.class);
            startActivity(toMain);
        } else if (v.getId() == R.id.login_cr) {
            Intent toLogin = new Intent(CreateAccActivity.this, LoginActivity.class);
            startActivity(toLogin);
        }

    }
}
