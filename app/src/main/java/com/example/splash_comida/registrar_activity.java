package com.example.splash_comida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registrar_activity extends AppCompatActivity {
    private FirebaseAuth nAuth;
    private EditText emailR,passR;
    private FloatingActionButton ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_activity);
        emailR = findViewById(R.id.emailR);
        passR  = findViewById(R.id.passR);
        ingresar = findViewById(R.id.btnIngresarR);

        nAuth   = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = nAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("User:",""+currentUser);

    }
    public void createUserWithEmailandPasswrod(String email, String password){
        nAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("EXITO", "Usuario creado");
                    FirebaseUser user = nAuth.getCurrentUser();
                    updateUI(user);
                }else{
                    Log.w("ERROR","Fallo en la creacion de usuario", task.getException());
                    Toast.makeText(registrar_activity.this,"Fallo en la autentificacion",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

    public void buttonPress(View view){
        String email = emailR.getText().toString();
        String password= passR.getText().toString();

        if(!email.isEmpty()&&!password.isEmpty()){
            if(password.length()>5){
                createUserWithEmailandPasswrod(email,password);
                startActivity(new Intent(getApplicationContext(),Login_activity.class));
            }
        }else{
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}