package com.example.practicaandroid.spinnerPersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicaandroid.R;

public class SpinnerPersonalizado extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public SpinnerPersonalizado(@NonNull Context context, Datos[] datos) {
        super(context, R.layout.imagen_spinner, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.imagen_spinner,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.avatarSpinner);
        Datos elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.imagen_spinner,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.avatarSpinner);
        Datos elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }
}
