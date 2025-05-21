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

public class Login_Activity extends AppCompatActivity {
    EditText edit_email;
    EditText edit_psw;
    CardView card_login;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Login_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_email = findViewById(R.id.edit_email);
        edit_psw = findViewById(R.id.edit_psw);
        card_login = findViewById(R.id.card_login);
        img_back = findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        card_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_email.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Login_Activity.this,"Please Enter Email", Toast.LENGTH_SHORT).show();
                }else if (edit_psw.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Login_Activity.this,"Please Enter password", Toast.LENGTH_SHORT).show();
                }else {
                    Intent inte = new Intent(Login_Activity.this,Methods_Activity.class);
                    startActivity(inte);
                }
            }
        });



    }
}