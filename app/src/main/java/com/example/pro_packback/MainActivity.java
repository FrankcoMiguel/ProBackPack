package com.example.pro_packback;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private NavigationView navigationView;

    private TextView name, grade;


    private TextView tvHeaderName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Layout variables binding
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Drawer Component Setup
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //First Fragment -- Homepage
        if (savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomepageFragment()).commit();
            navigationView.setCheckedItem(R.id.homepage);

        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.homepage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomepageFragment()).commit();
                break;

            case R.id.homework:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeworkFragment()).commit();
                break;

            case R.id.edit_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;

            case R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingFragment()).commit();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(Gravity.START)){

            drawer.closeDrawer(Gravity.START);

        } else {

        super.onBackPressed();

        }
    }
}
