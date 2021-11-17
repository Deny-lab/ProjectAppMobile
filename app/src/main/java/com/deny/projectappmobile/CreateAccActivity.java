package com.deny.projectappmobile;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
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

import java.util.regex.Pattern;


public class CreateAccActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView registerUser;
    private EditText editTextFullname, editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (ImageView) findViewById(R.id.create_cr);
        registerUser.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email_cr);
        editTextFullname = (EditText) findViewById(R.id.fullname_cr);
        editTextPassword = (EditText) findViewById(R.id.pass_cr);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        ImageView btnBack = findViewById(R.id.back_cr);
        btnBack.setOnClickListener(this);

        ImageView btnCreate = findViewById(R.id.create_cr);
        btnCreate.setOnClickListener(this);

        ImageView btnLogin = findViewById(R.id.login_cr);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back_cr:
                startActivity(new Intent(this, LandingActivity.class));
                break;
            case R.id.create_cr:
                registerUser();
                break;

        }

//        if (v.getId() == R.id.back_cr) {
//            Intent toLanding = new Intent(CreateAccActivity.this, LandingActivity.class);
//            startActivity(toLanding);
//        } else if (v.getId() == R.id.create_cr) {
//            Intent toMain = new Intent(CreateAccActivity.this, MainActivity.class);
//            startActivity(toMain);
//        } else if (v.getId() == R.id.login_cr) {
//            Intent toLogin = new Intent(CreateAccActivity.this, LoginActivity.class);
//            startActivity(toLogin);
//        }

    }

    private void registerUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullname = editTextFullname.getText().toString().trim();

        if (fullname.isEmpty()){
            editTextFullname.setError("Fullname is required!");
            editTextFullname.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Min password should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.GONE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(fullname, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(CreateAccActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(CreateAccActivity.this, "Failed to Registered! Try Again!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(CreateAccActivity.this, "Failed to Registered! Try Again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}
