package com.example.ejemplolistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaro ListView
        ListView listado = findViewById(R.id.listado);

        // Declaro fuente de datos (array, ArrayList...)
        final String datos[] = {"Opción1", "Opción2", "Opción3", "Opción4", "Opción5"};

        // Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        // Asigno el adaptador
        listado.setAdapter(adaptador);

        // Creo un listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                // Opción 1: no hacerlo porque no es consistente aunque funcione
                //Toast.makeText(MainActivity.this, datos[posicion], Toast.LENGTH_SHORT).show();

                // Opción 2
                //Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(posicion).toString(), Toast.LENGTH_SHORT).show();

                // Opción 3
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(posicion).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}