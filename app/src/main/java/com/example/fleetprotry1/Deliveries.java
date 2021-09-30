package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Deliveries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_deliveries);

        ImageView home = findViewById(R.id.homerect);
        Button dlist = (Button) findViewById(R.id.delist);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        dlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDlvryInfo();
            }
        });
    }
    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openDlvryInfo(){
        Intent intent =new Intent(this, DeliveryInfo.class);
        startActivity(intent);
    }
}