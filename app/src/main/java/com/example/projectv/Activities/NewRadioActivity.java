package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectv.R;

public class NewRadioActivity extends AppCompatActivity {
    RelativeLayout relativecontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_radio);
        relativecontinue = findViewById(R.id.relativecontinue);
        relativecontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(NewRadioActivity.this, SignupActivity.class);
                startActivity(sign);
            }
        });
    }
}