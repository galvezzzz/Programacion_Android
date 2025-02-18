package com.example.ej8tema7;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class AdaptadorPersonalizado extends BaseAdapter {
    private ArrayList<Datos> datos;
    private Context context;

    public AdaptadorPersonalizado(ArrayList<Datos> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mostrado = LayoutInflater.from(context);
        View elemento = mostrado.inflate(R.layout.spinner, null);

        ImageView img = (ImageView) elemento.findViewById(R.id.imagen);
        img.setImageResource(datos.get(i).getImagen());

        return elemento;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner, parent, false);
        }

        ImageView icono = convertView.findViewById(R.id.imagen);
        Datos elemento = datos.get(position);

        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
