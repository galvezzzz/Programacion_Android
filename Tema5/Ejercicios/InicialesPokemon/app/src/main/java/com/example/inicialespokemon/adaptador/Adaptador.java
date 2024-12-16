package com.example.inicialespokemon.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.inicialespokemon.datos.Datos;
import com.example.inicialespokemon.R;

public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.pantalla_inicio, datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.pantalla_inicio, parent, false);

        ImageView imagen = (ImageView) elemento.findViewById(R.id.imagenRegion);
        imagen.setImageResource(datos[position].getImagenRegion());

        return elemento;
    }
}
