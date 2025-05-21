package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.projectv.R;

import java.util.Calendar;

public class Calender_Activity extends AppCompatActivity {
  TextView txt_date;
  TextView txt_time;
  Button bt_selectdate;
  Button bt_selecttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        txt_date = findViewById(R.id.txt_date);
        txt_time = findViewById(R.id.txt_time);
        bt_selectdate = findViewById(R.id.bt_selectdate);
        bt_selecttime = findViewById(R.id.bt_selecttime);

        bt_selectdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DatePicker();
    }
});
        bt_selecttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker();
            }
        });


    }

    private void TimePicker() {
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txt_time.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
            }
        },15,00,true);
        dialog.show();

    }

    private  void DatePicker(){
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txt_date.setText(String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(dayOfMonth));
            }
        },2024,0,15);
        dialog.show();
    }
}