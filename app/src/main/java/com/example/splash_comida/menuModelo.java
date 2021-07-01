package com.example.splash_comida;

public class menuModelo {
    private String  titulo,contenido;
    private int fotoMenu;

    public menuModelo() {
    }

    public menuModelo(String titulo, String contenido, int fotoMenu) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fotoMenu = fotoMenu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getFotoMenu() {
        return fotoMenu;
    }

    public void setFotoMenu(int fotoMenu) {
        this.fotoMenu = fotoMenu;
    }
}
