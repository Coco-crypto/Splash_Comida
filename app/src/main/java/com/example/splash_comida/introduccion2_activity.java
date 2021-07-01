package com.example.splash_comida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class introduccion2_activity extends AppCompatActivity {
    ViewPager2 oficial;
    fragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion2_activity);
        oficial = findViewById(R.id.papel);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new fragmentAdapter(fm,getLifecycle());
        oficial.setAdapter(adapter);
    }
}