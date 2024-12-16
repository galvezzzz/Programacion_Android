package com.example.act1t5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancio el objeto
        ListView listado = (ListView) findViewById(R.id.lista1);
        //Declaro el array de valores
        final String datos[]= {"Messi","Cristiano","Neymar","Ramos","Benzema"};
        // Creo el adaptador para poder rellenar la lista, pasándole los datos
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        // Asocio el adaptador a la lista
        listado.setAdapter(adaptador);

        // Instancio el objeto
        ListView listado2 = (ListView) findViewById(R.id.lista2);
        //Declaro el array de valores
        final String datos2[]= {"Hazard","Bonucci","Suárez","Busquets","Lamine"};
        // Creo el adaptador para poder rellenar la lista, pasándole los datos
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos2);
        // Asocio el adaptador a la lista
        listado2.setAdapter(adaptador2);
    }
}