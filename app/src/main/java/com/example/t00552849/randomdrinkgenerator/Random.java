package com.example.t00552849.randomdrinkgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Random extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.HandTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setTitle(R.string.random);
    }

}