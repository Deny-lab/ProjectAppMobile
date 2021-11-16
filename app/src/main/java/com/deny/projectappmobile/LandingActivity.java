package com.deny.projectappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        ImageView btnCreateAcc = findViewById(R.id.create_account);
        btnCreateAcc.setOnClickListener(this);

        ImageView btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.create_account) {
            Intent moveCreate = new Intent(LandingActivity.this, CreateAccActivity.class);
            startActivity(moveCreate);
        } else if(v.getId() == R.id.btn_login) {
            Intent moveLogin = new Intent(LandingActivity.this, LoginActivity.class);
            startActivity(moveLogin);
        }
    }
}
