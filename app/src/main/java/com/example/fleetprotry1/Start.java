package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Start extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        Button signInButton = (Button) findViewById(R.id.button);
        Button signUpButton = (Button) findViewById(R.id.button2);

        mAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }
    }

    public void openLogin(){
        Intent intent =new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent =new Intent(this, SignUp.class);
        startActivity(intent);
    }
}