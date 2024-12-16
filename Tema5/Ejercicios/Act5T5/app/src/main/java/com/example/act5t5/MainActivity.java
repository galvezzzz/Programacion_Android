package com.example.act5t5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        // Creo los datos que voy a mostrar en pantalla
        Datos[] datos = new Datos[]{
                new Datos("Rosa", "4353432356"),
                new Datos("Miguel", "3242352435"),
                new Datos("Jose", "34564e3431"),
                new Datos("Lucy", "645563432"),
        };

        // Instancio el objeto ListView
        ListView listado = findViewById(R.id.miLista);

        // Incorporo la cabecera
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(miCabecera);

        // Creo el adaptador
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        // Creo el manejador de eventos
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccionado = ((Datos) adapterView.getItemAtPosition(i)).getTexto1();
                Toast.makeText(MainActivity.this, "Has pulsado " + seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}