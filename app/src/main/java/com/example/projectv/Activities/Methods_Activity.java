package com.example.projectv.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projectv.Fragments.Bottom_sheet_Fragment;
import com.example.projectv.R;
import com.google.firebase.components.BuildConfig;

public class Methods_Activity extends AppCompatActivity {
     public Button bt_fragments;
     public Button bt_otp;
    Button bt_popup;
    Button bt_gmail;
    Button bt_googlemap;
    Button bt_botmpopup;
    Button bt_share;
    Button bt_login;
    Button bt_apis;
    Button bt_banners;
    Button bt_srr;
    Button bt_calender;
    Button bt_drawer;
    Button bt_register;
    Button bt_razorpay;
    Button bt_new;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Methods_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);

        bt_fragments = findViewById(R.id.bt_fragments);
        bt_popup = findViewById(R.id.bt_popup);
        bt_otp = findViewById(R.id.bt_otp);
        bt_gmail = findViewById(R.id.bt_gmail);
        bt_googlemap = findViewById(R.id.bt_googlemap);
        bt_botmpopup = findViewById(R.id.bt_botmpopup);
        bt_share = findViewById(R.id.bt_share);
        bt_login = findViewById(R.id.bt_login);
        bt_apis = findViewById(R.id.bt_apis);
        bt_banners = findViewById(R.id.bt_banners);
        bt_srr = findViewById(R.id.bt_srr);
        bt_calender = findViewById(R.id.bt_calender);
        bt_drawer = findViewById(R.id.bt_drawer);
        bt_register = findViewById(R.id.bt_register);
        bt_razorpay = findViewById(R.id.bt_razorpay);
        bt_new = findViewById(R.id.bt_new);
        
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neww  = new Intent(Methods_Activity.this, NewRadioActivity.class);
                startActivity(neww);
            }
        });

        bt_razorpay.setOnClickListener(view -> {
            Intent razor  = new Intent(Methods_Activity.this, Razorpay_Activity.class);
            startActivity(razor);
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register  = new Intent(Methods_Activity.this, Register_Activity.class);
                startActivity(register);
            }
        });

        bt_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drawer  = new Intent(Methods_Activity.this, Drawer_Activity.class);
                startActivity(drawer);
            }
        });

        bt_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calender  = new Intent(Methods_Activity.this, Calender_Activity.class);
                startActivity(calender);
            }
        });

        bt_srr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent srr  = new Intent(Methods_Activity.this, Spin_Rate_RadioActivity.class);
                startActivity(srr);
            }
        });

        bt_banners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent banner  = new Intent(Methods_Activity.this, Banners_Activity.class);
                startActivity(banner);
            }
        });

        bt_apis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent api  = new Intent(Methods_Activity.this, APIS_Activity.class);
                startActivity(api);
            }
        });

        bt_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment  = new Intent(Methods_Activity.this, Fragments_Activity.class);
                startActivity(fragment);
            }
        });
        bt_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otp = new Intent(Methods_Activity.this,Otp_Activity.class);
                startActivity(otp);
            }
        });
        bt_googlemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Methods_Activity.this,GoogleMap_Activity.class);
                startActivity(map);
            }
        });

        bt_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custompopup();
            }

            private void Custompopup() {
                AlertDialog dialog;
                AlertDialog.Builder mbuilder =new AlertDialog.Builder(Methods_Activity.this);
                View mview =  LayoutInflater.from(Methods_Activity.this).inflate(R.layout.custom_popup,null);
                TextView bt_yes =(TextView) mview.findViewById(R.id.txt_ok);
                TextView bt_no=(TextView) mview.findViewById(R.id.txt_cancel);

                mbuilder.setView(mview);
                dialog=mbuilder.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);

                bt_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {dialog.dismiss();

                    }
                });
                bt_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {dialog.dismiss();
                    }
                });
            }
        });

        bt_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail = new Intent(Methods_Activity.this, Gmail_Login_Activity.class);
                startActivity(gmail);
            }
        });

        bt_botmpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bottom_sheet_Fragment bottom_sheet_fragment = new Bottom_sheet_Fragment();
                bottom_sheet_fragment.show(getSupportFragmentManager(),bottom_sheet_fragment.getTag());

            }
        });
        bt_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Project V");
                String shareMessage = "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID+"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent,"choose one"));
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drawer = new Intent(Methods_Activity.this, Login_Activity.class);
                startActivity(drawer);
            }
        });


    }


    }

