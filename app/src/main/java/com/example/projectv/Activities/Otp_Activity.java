package com.example.projectv.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectv.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otp_Activity extends AppCompatActivity {
    EditText edit_mobileno;
    EditText edit_otp;
    Button bt_getotp;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Otp_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        edit_mobileno  = findViewById(R.id.edit_mobileno);
        edit_otp  = findViewById(R.id.edit_otp);
        bt_getotp  = findViewById(R.id.bt_getotp);
        bt_register  = findViewById(R.id.bt_register);

        bt_getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edit_mobileno.getText().toString().trim();
                 if (phoneNumber.length() != 10){
                    edit_mobileno.setError("Please Enter valid Mobile Number");
                }else {
                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + phoneNumber, 60, TimeUnit.SECONDS, Otp_Activity.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInuser(phoneAuthCredential);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {

                        }

                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            super.onCodeSent(s, forceResendingToken);
                            bt_register.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String verificationcode = edit_otp.getText().toString().trim();
                                    if (s.isEmpty())return;
                                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(s,verificationcode);
                                    signInuser(phoneAuthCredential);
                                }
                            });
                        }
                    });

                }
            }
        });

    }
    private void signInuser(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Otp_Activity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                        }else {
                            edit_otp.setError("Log In failed");
                        }
                    }
                });
    }
}