package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectv.R;

public class Register_Activity extends AppCompatActivity {

    CardView card_register;

    EditText edit_name;
    EditText edit_mobile;
    EditText edit_email;
    EditText edit_psw;

    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Register_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_name = findViewById(R.id.edit_name);
        edit_mobile = findViewById(R.id.edit_mobile);
        edit_email = findViewById(R.id.edit_email);
        edit_psw = findViewById(R.id.edit_psw);
        card_register = findViewById(R.id.card_register);
        img_back = findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        card_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_name.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Register_Activity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else if (edit_mobile.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Register_Activity.this, "Please Enter mobile number", Toast.LENGTH_SHORT).show();
                } else if (edit_email.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Register_Activity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (edit_psw.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Register_Activity.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                }else {
                    Intent inte = new Intent(Register_Activity.this,Login_Activity.class);
                    startActivity(inte);
                }
            }
        });



    }
}