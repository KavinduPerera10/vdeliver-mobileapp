package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wallet);

        ImageView home = findViewById(R.id.homerect);
        Button cod = findViewById(R.id.cod);
        Button cop = findViewById(R.id.cop);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCOD();
            }
        });

        cop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCOP();
            }
        });
    }
    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openCOD(){
        Intent intent =new Intent(this, COD.class);
        startActivity(intent);
    }

    public void openCOP(){
        Intent intent =new Intent(this, COP.class);
        startActivity(intent);
    }
}