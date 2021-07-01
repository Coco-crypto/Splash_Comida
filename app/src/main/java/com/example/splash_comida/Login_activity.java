package com.example.splash_comida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_activity extends AppCompatActivity {
Button nuevo,loginN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        loginN = findViewById(R.id.btnLoginPrincipal);
        nuevo = findViewById(R.id.btnNuevaCuentaPrincipal);


        loginN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Login_activity.this, ingresar_activity.class);
                startActivity(intent);

            }
        });
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Login_activity.this, registrar_activity.class);
                startActivity(intent);

            }
        });
    }
}