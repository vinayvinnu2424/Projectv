package com.example.projectv.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.projectv.Fragments.Map_Fragment;
import com.example.projectv.R;

public class GoogleMap_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(GoogleMap_Activity.this,R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();

    }
}