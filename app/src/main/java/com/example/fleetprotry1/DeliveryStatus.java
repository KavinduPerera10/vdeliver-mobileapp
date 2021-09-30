package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_delivery_status);

        ImageView back = findViewById(R.id.back);
        ImageView home = findViewById(R.id.homerect);
        Button save = findViewById(R.id.save);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeliveryInfo();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeliveries();
            }
        });
    }

    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openDeliveries(){
        Intent intent =new Intent(this, Deliveries.class);
        startActivity(intent);
    }

    public void openDeliveryInfo(){
        Intent intent =new Intent(this, DeliveryInfo.class);
        startActivity(intent);
    }
}