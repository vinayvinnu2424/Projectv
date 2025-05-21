package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectv.R;

public class RegisternumberActivity extends AppCompatActivity {
    RelativeLayout relativesave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registernumber);
        relativesave = findViewById(R.id.relativesave);

        relativesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monthly = new Intent(RegisternumberActivity.this, MonthlyexpensesActivity.class);
                startActivity(monthly);
            }
        });
    }
}