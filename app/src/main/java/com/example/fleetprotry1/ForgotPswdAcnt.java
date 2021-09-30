package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPswdAcnt extends AppCompatActivity {

    private Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_pswd);

        get = (Button) findViewById(R.id.getcodebtn);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewPassword();
            }
        });

    }
    public void openNewPassword(){
        Intent intent =new Intent(this, NewPswdAcnt.class);
        startActivity(intent);
    }

}