package com.deny.projectappmobile;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView register;
    private EditText editTextEmail, editTextPassword;
    private ImageView signIn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (ImageView) findViewById(R.id.create_log);
        register.setOnClickListener(this);

        signIn = (ImageView) findViewById(R.id.login_log);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email_log);
        editTextPassword = (EditText) findViewById(R.id.password_log);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        mAuth = FirebaseAuth.getInstance();

//        mAuth = FirebaseAuth.getInstance();
//
//        ImageView btnBack = findViewById(R.id.back_1);
//        btnBack.setOnClickListener(this);
//
//        ImageView btnLogin = findViewById(R.id.login_log);
//        btnLogin.setOnClickListener(this);
//
//        ImageView btnCreate = findViewById(R.id.create_log);
//
//        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.create_log:
                startActivity(new Intent(this, CreateAccActivity.class));
                break;

            case R.id.login_log:
                userLogin();
                break;
        }

//        if (v.getId() == R.id.back_1) {
//            Intent back = new Intent(LoginActivity.this, LandingActivity.class);
//            startActivity(back);
//        } else if (v.getId() == R.id.login_log) {
//            Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(toMain);
//        } else if (v.getId() == R.id.create_log) {
//            Intent toCreate = new Intent(LoginActivity.this, CreateAccActivity.class);
//            startActivity(toCreate);
//
//        }
    }

    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setText("Please enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Min password length is 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Failed to login!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}