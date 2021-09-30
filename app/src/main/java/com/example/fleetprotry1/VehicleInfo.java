package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class VehicleInfo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    private Button save;

    private TextInputEditText vtype, vnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        vtype= (TextInputEditText) findViewById(R.id.vehicleType);
        vnum = (TextInputEditText) findViewById(R.id.vehicleNumber);

        save = findViewById(R.id.saveBtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }
    public void openHome(){
        String vtp = vtype.getText().toString().trim();
        String vnm = vnum.getText().toString().trim();

        if (vtp.isEmpty()) {
            vtype.setError("Vehicle Type is required!");
            vtype.requestFocus();
            return;
        }
        if (vnm.isEmpty()) {
            vnum.setError("Vehicle number is required!");
            vnum.requestFocus();
            return;
        }
        try {
            VehicleDetails vehicleDetails = new VehicleDetails(vtp, vnm );
            DocumentReference documentReference = fstore.collection("VehicleDetails")
                    .document(mAuth.getCurrentUser().getUid());
            documentReference.set(vehicleDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Vehicle details has been added successfully!", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "You are all set!", Toast.LENGTH_LONG).show();
                    Intent in =new Intent(getApplicationContext(), Home.class);
                    startActivity(in);
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}