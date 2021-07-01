package com.example.splash_comida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMenu extends AppCompatActivity {
    private RecyclerView   RecyclerViewMenu;
    private adaptadorMenu adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_menu);


        RecyclerViewMenu =(RecyclerView)findViewById(R.id.recicler_menu);
        RecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new adaptadorMenu(obtenerMenus());
        RecyclerViewMenu.setAdapter(adaptador);

    }

    public List<menuModelo> obtenerMenus(){
        List<menuModelo> menus = new ArrayList<>();
        menus.add(new menuModelo("CALDOS ERNESTINA ","Horario de apertura de 8am a 9pm ",R.drawable.caldo));
        menus.add(new menuModelo("CHI SE JON ","Horario de apertura de 8am a 9pm ",R.drawable.chifa));
        menus.add(new menuModelo("POLLOS BRO´S ","Horario de apertura de 8am a 9pm ",R.drawable.pollo));
        return menus;
    }
}