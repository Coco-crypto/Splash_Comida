package com.example.splash_comida;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptadorMenu extends RecyclerView.Adapter<adaptadorMenu.ViewHolder> {

public static class ViewHolder extends RecyclerView.ViewHolder{
    private TextView titulo,contenido;
    ImageView fotoMenu;


    public ViewHolder(View itemView){

        super(itemView);
        titulo = (TextView)itemView.findViewById(R.id.tTitulo);
        contenido = (TextView)itemView.findViewById(R.id.tContenido);
        fotoMenu = (ImageView)itemView.findViewById(R.id.fotoMenu);

    }
}

    public List<menuModelo> menuLista;

    public adaptadorMenu(List<menuModelo> menuLista) {
        this.menuLista = menuLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(menuLista.get(position).getTitulo());
        holder.contenido.setText(menuLista.get(position).getContenido());
        holder.fotoMenu.setImageResource(menuLista.get(position).getFotoMenu());
    }

    @Override
    public int getItemCount() {
        return menuLista.size();
    }
}
