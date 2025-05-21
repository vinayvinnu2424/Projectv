package com.example.projectv.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.projectv.R;
import com.google.android.material.navigation.NavigationView;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class Navigation_Drawer extends AppCompatActivity {
    DuoDrawerLayout duonavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        DuoDrawerLayout drawerLayout = (DuoDrawerLayout) findViewById(R.id.duonavigation);
//        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, drawerLayout, toolbar,
//                R.string.open,
//                R.string.close);
//
//        drawerLayout.setDrawerListener(drawerToggle);
//        drawerToggle.syncState();
    }

}