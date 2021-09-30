package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Vehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vehicle);

        ImageView home = findViewById(R.id.homerect);
        Button upg = findViewById(R.id.upgrade);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        upg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVehiUpgrades();
            }
        });
    }
    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }
    public void openVehiUpgrades(){
        Intent intent =new Intent(this, VehiUpgrades.class);
        startActivity(intent);
    }
}