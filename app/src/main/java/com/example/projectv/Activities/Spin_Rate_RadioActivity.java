package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projectv.R;

public class Spin_Rate_RadioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    RatingBar rating_bar;
    RadioGroup radiogroup;
    RadioButton radio_button1;
    RadioButton radio_button2;
    RadioButton radio_button3;

    String result = "";

    String[] list = {"Vinay","Vinnu","Hema","Durga"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_rate_radio);

        spinner = findViewById(R.id.spinner);
        rating_bar = findViewById(R.id.rating_bar);
        radiogroup = findViewById(R.id.radiogroup);
        radio_button1 = findViewById(R.id.radio_button1);
        radio_button2 = findViewById(R.id.radio_button2);
        radio_button3 = findViewById(R.id.radio_button3);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter vh = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        vh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(vh);


        radiogroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_button1.isChecked()){
                    result = radio_button1.getText().toString();
                }else if (radio_button2.isChecked()){
                    result = radio_button2.getText().toString();
                }else if (radio_button3.isChecked()){
                    result = radio_button3.getText().toString();
                }else {
                }
                Toast.makeText(getApplicationContext(), result+"", Toast.LENGTH_SHORT).show();
            }
        });

        rating_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rating_bar.isClickable()){
                    rating_bar.setRating(1);
                }else if (rating_bar.isClickable()){
                    rating_bar.setRating(2);
                }else if (rating_bar.isClickable()){
                    rating_bar.setRating(3);
                }else if (rating_bar.isClickable()) {
                    rating_bar.setRating(4);
                }else if (rating_bar.isClickable()){
                    rating_bar.setRating(5);
                }else {
                }
                Toast.makeText(getApplicationContext(), (int) rating_bar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

    }
//spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), list[position]+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    }