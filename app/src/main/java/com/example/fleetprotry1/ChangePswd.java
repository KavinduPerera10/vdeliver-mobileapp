package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePswd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_change_pswd);

        Button fgtPswd = (Button) findViewById(R.id.fgtbtn);
        Button reset = (Button) findViewById(R.id.resbtn);

        fgtPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPswd();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPasswordUpdated();
            }
        });

    }
    public void openForgotPswd(){
        Intent intent =new Intent(this, ForgotPswd.class);
        startActivity(intent);
    }

    public void openPasswordUpdated(){
        Intent intent =new Intent(this, PasswordUpdated.class);
        startActivity(intent);
    }
}