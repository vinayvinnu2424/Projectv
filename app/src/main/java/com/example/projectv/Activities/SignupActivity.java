package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projectv.R;

public class SignupActivity extends AppCompatActivity {
    RelativeLayout relativesignupbt;
    RelativeLayout relativelogin;
    RelativeLayout relativesignup;
    TextView txt_login;
    TextView txt_signp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        relativesignupbt = findViewById(R.id.relativesignupbt);
        relativelogin = findViewById(R.id.relativelogin);
        relativesignup = findViewById(R.id.relativesignup);
        txt_login = findViewById(R.id.txt_login);
        txt_signp = findViewById(R.id.txt_signp);

        relativesignupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otp = new Intent(SignupActivity.this,OtploginActivity.class);
                startActivity(otp);
            }
        });
        relativelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativelogin.setBackgroundColor(getResources().getColor(R.color.red));

                // Reset the background color of relativeLayout2
                relativesignup.setBackgroundColor(getResources().getColor(R.color.brown));
                txt_login.setTextColor(getResources().getColor(R.color.white));
                txt_signp.setTextColor(getResources().getColor(R.color.red));
            }
        });
        relativesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativelogin.setBackgroundColor(getResources().getColor(R.color.brown));
                // Reset the background color of relativeLayout2
                relativesignup.setBackgroundColor(getResources().getColor(R.color.red));

                txt_signp.setTextColor(getResources().getColor(R.color.white));
                txt_login.setTextColor(getResources().getColor(R.color.red));
            }
        });


    }
}