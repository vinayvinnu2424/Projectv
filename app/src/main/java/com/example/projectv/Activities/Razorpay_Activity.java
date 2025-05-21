package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.projectv.Config.InterNetConnectivityCheck;
import com.example.projectv.R;
import com.razorpay.Checkout;

import org.json.JSONObject;

public class Razorpay_Activity extends AppCompatActivity {

    RelativeLayout relative_payment_success;
    Button bt_complete;
    RelativeLayout relative_payment_failed;
    Button bt_failed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razorpay);

        relative_payment_success = findViewById(R.id.relative_payment_success);
        bt_complete = findViewById(R.id.bt_complete);
        relative_payment_failed = findViewById(R.id.relative_payment_failed);
        bt_failed = findViewById(R.id.bt_failed);

        bt_complete.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Methods_Activity.class);
            startActivity(intent);
        });

        bt_failed.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Methods_Activity.class);
            startActivity(intent);
        });


        if (InterNetConnectivityCheck.isOnline(getApplicationContext())){
            paymentMethod();
        }else {
            Toast.makeText(getApplicationContext(),"No InterNett",Toast.LENGTH_SHORT).show();
        }


    }

    private void paymentMethod() {
        final Activity activity = this;
        final Checkout co = new Checkout();
        try {
            JSONObject options = new JSONObject();
            options.put("name", "Project V");
            options.put("description", "testing");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("theme.color", "#8f30a5");
            options.put("currency", "INR");
            options.put("amount", "1000"+"00");
            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unused")
    public void onPaymentSuccess(String razorpayPaymentID) {
        try {
            relative_payment_success.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.e("Exception", String.valueOf(e));
        }
    }

    @SuppressWarnings("unused")
    public void onPaymentError(int code, String response) {
        try {
            relative_payment_failed.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.e("error", String.valueOf(e));
        }
    }


}