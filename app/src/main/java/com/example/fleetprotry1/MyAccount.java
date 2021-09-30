package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my_account);

        Button change = (Button) findViewById(R.id.changepswd);
        Button logout = (Button) findViewById(R.id.logout);
        ImageView home = findViewById(R.id.homerect);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangePswd();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

    }
    public void openChangePswd(){
        Intent intent =new Intent(this, ChangePswd.class);
        startActivity(intent);
    }

    public void openLogin(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
    }

    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }
}