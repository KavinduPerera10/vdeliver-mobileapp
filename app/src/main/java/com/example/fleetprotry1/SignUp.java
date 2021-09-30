package com.example.fleetprotry1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    private TextInputEditText email, pswd, cnfmpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        Button signUp = (Button) findViewById(R.id.signUpBtn);
        Button mem = (Button) findViewById(R.id.member);

        email = (TextInputEditText) findViewById(R.id.email);
        pswd = (TextInputEditText) findViewById(R.id.pswd);
        cnfmpswd = (TextInputEditText) findViewById(R.id.compswd);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openYourInfo();
                registerUser();
            }
        });

        mem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

    }

    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /*public void openYourInfo(){
        Intent intent =new Intent(this, YourInfo.class);
        startActivity(intent);
    }*/

    private void registerUser() {
        String eml = email.getText().toString().trim();
        String ps = pswd.getText().toString().trim();
        String cps = cnfmpswd.getText().toString().trim();

        if (eml.isEmpty()) {
            email.setError("Your Email is required!");
            email.requestFocus();
            return;
        }
        if (ps.isEmpty()) {
            pswd.setError("A password is required!");
            pswd.requestFocus();
            return;
        }
        if (cps.isEmpty()) {
            cnfmpswd.setError("Confirmation of the password is required!");
            cnfmpswd.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) {
            email.setError("Please provide a valid Email!");
            email.requestFocus();
            return;
        }

        if (ps.length() < 6) {
            pswd.setError("Password should be minimum 6 characters!");
            pswd.requestFocus();
        }

        if (!ps.equals(cps)) {
            cnfmpswd.setError("Passwords not matching!");
            cnfmpswd.requestFocus();
            return;
        }
        try {
            mAuth.createUserWithEmailAndPassword(eml, ps)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            User user = new User(eml);
                            DocumentReference documentReference = fstore.collection("Users")
                                    .document(mAuth.getCurrentUser().getUid());
                            documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getApplicationContext(), "Your Email has been registered successfully!", Toast.LENGTH_LONG).show();
                                    Intent in = new Intent(getApplicationContext(), YourInfo.class);
                                    startActivity(in);
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
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
