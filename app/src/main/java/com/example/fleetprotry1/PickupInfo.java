package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PickupInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pickup_info);

        ImageView home = findViewById(R.id.homerect);
        ImageView back = findViewById(R.id.back);
        Button upd = findViewById(R.id.update);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPickups();
            }
        });

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPickupStatus();
            }
        });
    }
    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openPickups(){
        Intent intent =new Intent(this, Pickups.class);
        startActivity(intent);
    }

    public void openPickupStatus(){
        Intent intent =new Intent(this, PickupStatus.class);
        startActivity(intent);
    }
}