package com.example.practicaandroid.adaptador;

public class Datos {

    private int indice;
    private String nombre;
    private String telefono;
    private int avatar;

    public Datos(int indice, String nombre, String telefono, int avatar){
        this.indice = indice;
        this.nombre = nombre;
        this.telefono = telefono;
        this.avatar = avatar;
    }

    public int getIndice() {
        return indice;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getAvatar() {
        return avatar;
    }
}
