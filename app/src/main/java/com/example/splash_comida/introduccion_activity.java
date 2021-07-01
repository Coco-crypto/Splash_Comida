package com.example.splash_comida;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;


public class introduccion_activity extends AppCompatActivity {
    private MediaPlayer nMP;


    ImageView que,chevere,fondo,fondoLogo;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduccion_activity);

        nMP = MediaPlayer.create(introduccion_activity.this, R.raw.audio_piloto);
        nMP.start();


        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        que = findViewById(R.id.que_splash);
        chevere = findViewById(R.id.chevere_splash);
        fondoLogo = findViewById(R.id.fondo_logo);
        fondo = findViewById(R.id.fondo_splash);
        lottie  = findViewById(R.id.lottie);



        que.setAnimation(animacion1);
        chevere.setAnimation(animacion1);
        fondo.setAnimation(animacion1);
        lottie.setAnimation(animacion1);




        fondo.animate().translationY(1400).setDuration(6000).setStartDelay(7000);
        que.animate().translationY(1400).setDuration(5000).setStartDelay(7000);
        chevere.animate().translationY(1400).setDuration(4000).setStartDelay(7000);
        lottie.animate().translationY(1400).setDuration(3000).setStartDelay(7000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(introduccion_activity.this, introduccion2_activity.class);
                startActivity(intent);
                finish();
            }
        },6000);

    }


}