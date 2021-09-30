package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class COP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_c_o_p);

        ImageView back = findViewById(R.id.back);
        ImageView home = findViewById(R.id.homerect);
        Button add = findViewById(R.id.adwlt);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWallet();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWallet();
            }
        });
    }

    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openWallet(){
        Intent intent =new Intent(this, Wallet.class);
        startActivity(intent);
    }
}