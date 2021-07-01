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

public class ingresar_activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailE,passE;
    private FloatingActionButton ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_activity);

        emailE = findViewById(R.id.Eemail);
        passE   = findViewById(R.id.Epass);
        ingresar = findViewById(R.id.btnIngresar);

        mAuth   = FirebaseAuth.getInstance();
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("User:",""+currentUser);

    }
    public void signInWithEmailAndPassword(String Email, String Password){
        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("EXITO", "Usuario correcto");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                }else{
                    Log.w("ERROR","Fallo en la creacion de usuario", task.getException());
                    Toast.makeText(ingresar_activity.this,"Fallo en la autentificacion",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    public void buttonPress(View view){
        String email= emailE.getText().toString() ;
        String password = passE.getText().toString();
        if(!email.isEmpty()&&!password.isEmpty()){
            if(password.length()>5){
                signInWithEmailAndPassword(email,password);
                startActivity(new Intent(getApplicationContext(),Bienvenida.class));
            }
        }else{
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void buttonPressbienvenida(View view){
        startActivity(new Intent(getApplicationContext(),RecyclerViewMenu.class));
    }
}