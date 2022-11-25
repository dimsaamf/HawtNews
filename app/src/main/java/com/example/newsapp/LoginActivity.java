package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmailLogin, etPasswdLogin;
    private FirebaseAuth mAuth;
    private Button btnSignUpLogin, btnSignInLogin;
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        etEmailLogin = findViewById(R.id.etUsernameLogin);
        etPasswdLogin = findViewById(R.id.etPasswdLogin);
        btnSignInLogin = findViewById(R.id.btnSignInLogin);
        btnSignInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLogin();
            }
        });
        btnSignUpLogin = findViewById(R.id.btnSignUpLogin);
        btnSignUpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }

        });
    }

    private void cekLogin() {
        email = etEmailLogin.getText().toString();
        password = etPasswdLogin.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
    });
}
}