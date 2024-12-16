package com.example.ejemplogridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Grid;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancio el listado
        final GridView listado = findViewById(R.id.listado);

        // Creo la fuente de datos
        final String datos[] = {"Elemento 1", "Elemento 2", "Elemento 3","Elemento 4","Elemento 5"};

        // Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        // Asigno el adaptador
        listado.setAdapter(adaptador);

        // Añado un listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                // Opción 1:
                Toast.makeText(MainActivity.this,"Has hecho click en " + adapterView.getItemIdAtPosition(posicion), Toast.LENGTH_SHORT).show();

                // Opción 2:
                Toast.makeText(MainActivity.this,"Has hecho click en " + adapterView.getAdapter().getItem(posicion), Toast.LENGTH_SHORT).show();

                // Opción 3:
                Toast.makeText(MainActivity.this,"Has hecho click en " + adapterView.getItemIdAtPosition(posicion), Toast.LENGTH_SHORT).show();


            }
        });



    }
}