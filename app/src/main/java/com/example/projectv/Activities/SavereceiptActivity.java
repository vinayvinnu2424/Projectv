package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectv.R;

public class SavereceiptActivity extends AppCompatActivity {
    RelativeLayout relativesave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savereceipt);
        relativesave = findViewById(R.id.relativesave);

        relativesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regno = new Intent(SavereceiptActivity.this,RegisternumberActivity.class);
                startActivity(regno);

            }
        });
    }
}