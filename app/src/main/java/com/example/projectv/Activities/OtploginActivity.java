package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectv.R;

public class OtploginActivity extends AppCompatActivity {
    RelativeLayout relativelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin);
        relativelogin = findViewById(R.id.relativelogin);
        relativelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donor = new Intent(OtploginActivity.this,DonorActivity.class);
                startActivity(donor);
            }
        });
    }
}