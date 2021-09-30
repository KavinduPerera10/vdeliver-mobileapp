package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPswd extends AppCompatActivity {

    private Button get;
    private Button backSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_pswd);

        get = (Button) findViewById(R.id.getcodebtn);
        backSignIn = (Button) findViewById(R.id.backSignIn);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewPassword();
            }
        });

        backSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }
    public void openNewPassword(){
        Intent intent =new Intent(this, NewPassword.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent =new Intent(this, Login.class);
        startActivity(intent);
    }
}