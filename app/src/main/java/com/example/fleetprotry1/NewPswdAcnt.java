package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewPswdAcnt extends AppCompatActivity {

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        reset = (Button) findViewById(R.id.resbtn);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPasswordUpdated();
            }
        });
    }
    public void openPasswordUpdated(){
        Intent intent =new Intent(this, PasswordUpdated.class);
        startActivity(intent);
    }
}