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

public class YourInfo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    private Button next;

    private TextInputEditText fullname, dob, dlnum,phnnum, empid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        next = findViewById(R.id.nextBtn);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        fullname = (TextInputEditText) findViewById(R.id.name);
        empid = (TextInputEditText) findViewById(R.id.employeeID);
        dob = (TextInputEditText) findViewById(R.id.dob);
        dlnum = (TextInputEditText) findViewById(R.id.drivingLicenseNumber);
        phnnum = (TextInputEditText) findViewById(R.id.phoneNumber);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInfo();
            }
        });

        }
        public void checkInfo(){
            String name = fullname.getText().toString().trim();
            String dofb = dob.getText().toString().trim();
            String dlicnnum = dlnum.getText().toString().trim();
            String phonnum =phnnum.getText().toString().trim();
            String emplyid =empid.getText().toString().trim();

            if (name.isEmpty()) {
                fullname.setError("Your Name is required!");
                fullname.requestFocus();
                return;
            }
            if (emplyid.isEmpty()) {
                empid.setError("Your employee ID number is required!");
                empid.requestFocus();
                return;
            }
            if (dlicnnum.isEmpty()) {
                dlnum.setError("Your driving license number is required!");
                dlnum.requestFocus();
                return;
            }
            if (dofb.isEmpty()) {
                dob.setError("Your date of birth is required!");
                dob.requestFocus();
                return;
            }
            if (phonnum.isEmpty()) {
                phnnum.setError("Your phone number is required!");
                phnnum.requestFocus();
                return;
            }
            if (phonnum.length() != 10) {
                phnnum.setError("Enter your phone number containing 10 digits!");
                phnnum.requestFocus();
                return;
            }

            try {
                EmployeeDetails employeeDetails = new EmployeeDetails(name, dlicnnum, dofb, phonnum, emplyid );
                DocumentReference documentReference = fstore.collection("EmployeeDetails")
                        .document(mAuth.getCurrentUser().getUid());
                documentReference.set(employeeDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), "Your details has been added successfully!", Toast.LENGTH_LONG).show();
                        Intent in =new Intent(getApplicationContext(), VehicleInfo.class);
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

    /*public void openVehicleInfo(){
        Intent intent =new Intent(this, VehicleInfo.class);
        startActivity(intent);
    }*/

    }

