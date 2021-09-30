package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    private Button fgtPswd;
    private Button login;
    private Button newUser;

    private TextInputEditText password;
    private TextInputEditText email;

    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        fgtPswd = (Button) findViewById(R.id.fgtbtn);
        login = (Button) findViewById(R.id.loginbtn);
        newUser = (Button) findViewById(R.id.newbtn);

        email = (TextInputEditText) findViewById(R.id.email);
        password = (TextInputEditText) findViewById(R.id.pswd);

        fgtPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPswd();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
    }

    public void openSignUp(){
        Intent intent =new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void openForgotPswd(){
        Intent intent =new Intent(this, ForgotPswd.class);
        startActivity(intent);
    }

    public void openHome(){
        String eml = email.getText().toString().trim();
        String ps = password.getText().toString().trim();

        if (eml.isEmpty()) {
            email.setError("Your Email is required!");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) {
            email.setError("Please provide a valid Email!");
            email.requestFocus();
            return;
        }

        if (ps.isEmpty()) {
            password.setError("A password is required!");
            password.requestFocus();
            return;
        }

        if (ps.length() < 6) {
            password.setError("Password should be minimum 6 characters!");
            password.requestFocus();
        }

        mAuth.signInWithEmailAndPassword(eml,ps).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(getApplicationContext(), Home.class);
                    startActivity(in);
                }else{
                    Toast.makeText(Login.this,"Failed to login! Please check your credentials and try again!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}