package com.example.t00552849.randomdrinkgenerator;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottombaritem_home:
                                setContentView(R.layout.activity_main);
                                break;
                            case R.id.bottombaritem_favourites:
                                //takes you to the favourites page
                                break;
                            case R.id.bottombaritem_help:
                                //takes you to the help page
                                break;
                            case R.id.bottombaritem_settings:
                                //takes you to the settings page
                                break;
                        }
                        return true;
                    }
                });
    }

    protected void onClickCocktails(View view){
        Intent toCock= new Intent(MainActivity.this, Cocktails.class);
        MainActivity.this.startActivity(toCock);
    }

    protected void onClickCustom(View view){
        Intent toCustom = new Intent(MainActivity.this, Custom.class);
        MainActivity.this.startActivity(toCustom);
    }

    protected void onClickMocktails(View view){
        Intent toMock = new Intent(MainActivity.this, Mocktails.class);
        MainActivity.this.startActivity(toMock);
    }

    protected void onClickShooters(View view){
        Intent toShooter = new Intent(MainActivity.this, Shooters.class);
        MainActivity.this.startActivity(toShooter);
    }

    /*private void setNavigationViewListener(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.bottombaritem_favourites);
        navigationView.setNavigationItemSelectedListener(this);
    }*/


    /*@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }*/
}
