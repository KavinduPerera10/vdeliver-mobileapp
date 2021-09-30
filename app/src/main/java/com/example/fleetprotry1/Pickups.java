package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Pickups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pickups);

        ImageView home = findViewById(R.id.homerect);
        Button plist = (Button) findViewById(R.id.plist);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        plist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPickupInfo();
            }
        });
    }

    public void openHome(){
        Intent intent =new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openPickupInfo(){
        Intent intent =new Intent(this, PickupInfo.class);
        startActivity(intent);
    }
}