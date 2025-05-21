package com.example.projectv.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projectv.Fragments.Cart_Fragment;
import com.example.projectv.Fragments.Favourite_Fragment;
import com.example.projectv.Fragments.Home_Fragment;
import com.example.projectv.Fragments.Profile_Fragment;
import com.example.projectv.R;

public class Fragments_Activity extends AppCompatActivity  {

    ImageView img_back;
    ImageView img_homev;
    ImageView img_homeh;
    ImageView img_carthomev;
    ImageView img_carthomeh;
    ImageView img_favv;
    ImageView img_favh;
    ImageView img_profilev;
    ImageView img_profileh;

    TextView txt_home;
    TextView txt_carthome;
    TextView txt_fav;
    TextView txt_profile;

    RelativeLayout relative_top;
    RelativeLayout relative_home;
    RelativeLayout relative_cart;
    RelativeLayout relative_fav;
    RelativeLayout relative_profile;

    Fragment projectVfragment;
    public static FrameLayout fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Fragments_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        relative_top = findViewById(R.id.relative_top);
        relative_home = findViewById(R.id.relative_home);
        relative_cart = findViewById(R.id.relative_cart);
        relative_fav = findViewById(R.id.relative_fav);
        relative_profile = findViewById(R.id.relative_profile);

        img_homev = findViewById(R.id.img_homev);
        img_homeh = findViewById(R.id.img_homeh);
        img_carthomev = findViewById(R.id.img_carthomev);
        img_carthomeh = findViewById(R.id.img_carthomeh);
        img_favv = findViewById(R.id.img_favv);
        img_favh = findViewById(R.id.img_favh);
        img_profilev = findViewById(R.id.img_profilev);
        img_profileh = findViewById(R.id.img_profileh);
        img_back = findViewById(R.id.img_back);

        txt_home = findViewById(R.id.txt_home);
        txt_carthome = findViewById(R.id.txt_cart_home);
        txt_fav = findViewById(R.id.txt_fav);
        txt_profile = findViewById(R.id.txt_profile);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        relative_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Refresh();
            }
        });
        relative_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart_page();
            }
        });
        relative_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favourites();
            }
        });
        relative_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();
            }
        });

        projectVfragment = new Home_Fragment();
        changeFragment(projectVfragment);

    }

    private void profile() {
        relative_top.setVisibility(View.GONE);

        img_profilev.setVisibility(View.VISIBLE);
        img_profileh.setVisibility(View.INVISIBLE);
        img_homev.setVisibility(View.INVISIBLE);
        img_homeh.setVisibility(View.VISIBLE);
        img_carthomev.setVisibility(View.INVISIBLE);
        img_carthomeh.setVisibility(View.VISIBLE);
        img_favv.setVisibility(View.INVISIBLE);
        img_favh.setVisibility(View.VISIBLE);

        //text color
        txt_profile.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        txt_home.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_carthome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_fav.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        projectVfragment = new Profile_Fragment();
        changeFragment(projectVfragment);

    }

    private void favourites() {
        relative_top.setVisibility(View.GONE);

        img_favv.setVisibility(View.VISIBLE);
        img_favh.setVisibility(View.INVISIBLE);
        img_homev.setVisibility(View.INVISIBLE);
        img_homeh.setVisibility(View.VISIBLE);
        img_carthomev.setVisibility(View.INVISIBLE);
        img_carthomeh.setVisibility(View.VISIBLE);
        img_profilev.setVisibility(View.INVISIBLE);
        img_profileh.setVisibility(View.VISIBLE);
        //text color
        txt_fav.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        txt_home.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_carthome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_profile.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        projectVfragment = new Favourite_Fragment();
        changeFragment(projectVfragment);

    }

    private void cart_page() {
        relative_top.setVisibility(View.GONE);

        img_carthomev.setVisibility(View.VISIBLE);
        img_carthomeh.setVisibility(View.INVISIBLE);
        img_homev.setVisibility(View.INVISIBLE);
        img_homeh.setVisibility(View.VISIBLE);
        img_favv.setVisibility(View.INVISIBLE);
        img_favh.setVisibility(View.VISIBLE);
        img_profilev.setVisibility(View.INVISIBLE);
        img_profileh.setVisibility(View.VISIBLE);

        //text color
        txt_carthome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        txt_home.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_fav.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_profile.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        projectVfragment = new Cart_Fragment();
        changeFragment(projectVfragment);
    }

    private void Home_Refresh() {
        relative_top.setVisibility(View.VISIBLE);

        img_homev.setVisibility(View.VISIBLE);
        img_homeh.setVisibility(View.INVISIBLE);
        img_carthomev.setVisibility(View.INVISIBLE);
        img_carthomeh.setVisibility(View.VISIBLE);
        img_favv.setVisibility(View.INVISIBLE);
        img_favh.setVisibility(View.VISIBLE);
        img_profilev.setVisibility(View.INVISIBLE);
        img_profileh.setVisibility(View.VISIBLE);

        //text color
        txt_home.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        txt_carthome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_fav.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        txt_profile.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        projectVfragment = new Home_Fragment();
        changeFragment(projectVfragment);
    }
    public void onBackPressed() {
        AlertDialog dialog;
        AlertDialog.Builder mbuilder =new AlertDialog.Builder(Fragments_Activity.this);
        View mview =  LayoutInflater.from(Fragments_Activity.this).inflate(R.layout.dailouge_back,null);
        RelativeLayout bt_yes = (RelativeLayout) mview.findViewById(R.id.bt_yes);
        RelativeLayout bt_no = (RelativeLayout) mview.findViewById(R.id.bt_no);


        mbuilder.setView(mview);
        dialog=mbuilder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        bt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }
        });
        bt_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {dialog.dismiss();
            }
        });
    }


    private void changeFragment(Fragment projectV) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelay,projectV);
        transaction.addToBackStack("tag");
        transaction.commit();
    }
}