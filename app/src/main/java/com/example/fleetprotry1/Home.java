package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        Button deliveryBtn = findViewById(R.id.dlvryBtn);
        Button pickUpBtn = findViewById(R.id.pkupBtn);
        Button vehicleBtn = findViewById(R.id.vehiBtn);
        Button walletBtn = findViewById(R.id.waltBtn);
        Button msg = findViewById(R.id.message);
        ImageView accnt = findViewById(R.id.acntrect);
        ImageView notify = findViewById(R.id.noti);

        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeliveries();
            }
        });

        pickUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPickups();
            }
        });

        vehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVehicle();
            }
        });

        walletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWallet();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotifications();
            }
        });

        accnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccount();
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSendMsg();
            }
        });
    }

    public void openPickups(){
        Intent intent =new Intent(this, Pickups.class);
        startActivity(intent);
    }

    public void openDeliveries(){
        Intent intent =new Intent(this, Deliveries.class);
        startActivity(intent);
    }

    public void openVehicle(){
        Intent intent =new Intent(this, Vehicle.class);
        startActivity(intent);
    }

    public void openWallet(){
        Intent intent =new Intent(this, Wallet.class);
        startActivity(intent);
    }

    public void openNotifications(){
        Intent intent =new Intent(this, Notifications.class);
        startActivity(intent);
    }

    public void openAccount(){
        Intent intent =new Intent(this, MyAccount.class);
        startActivity(intent);
    }

    public void openSendMsg(){
        Intent intent =new Intent(this, SendMsg.class);
        startActivity(intent);
    }
}