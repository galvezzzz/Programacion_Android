package com.example.inicialespokemon.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inicialespokemon.adaptador.Adaptador;
import com.example.inicialespokemon.datos.Datos;
import com.example.inicialespokemon.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datos[] datos = new Datos[]{
                new Datos(R.drawable.kanto),
                new Datos(R.drawable.johto),
                new Datos(R.drawable.hoenn),
                new Datos(R.drawable.sinnoh),
                new Datos(R.drawable.teselia),
                new Datos(R.drawable.kalos),
                new Datos(R.drawable.alola),
                new Datos(R.drawable.galar),
                new Datos(R.drawable.paldea),
        };

        // Iniciar lista
        ListView listado = (ListView) findViewById(R.id.lista);

        // Incorporo la cabecera
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(miCabecera);

        // Iniciar adaptador
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        // Creo el manejador de eventos
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(MainActivity.this, Region.class);

                if (position == 1) {
                    intent.putExtra("region", "kanto");
                    startActivity(intent);
                } else if (position == 2) {
                    intent.putExtra("region", "johto");
                    startActivity(intent);
                } else if (position == 3) {
                    intent.putExtra("region", "hoenn");
                    startActivity(intent);
                } else if (position == 4) {
                    intent.putExtra("region", "sinnoh");
                    startActivity(intent);
                } else if (position == 5) {
                    intent.putExtra("region", "teselia");
                    startActivity(intent);
                } else if (position == 6) {
                    intent.putExtra("region", "kalos");
                    startActivity(intent);
                } else if (position == 7) {
                    intent.putExtra("region", "alola");
                    startActivity(intent);
                } else if (position == 8) {
                    intent.putExtra("region", "galar");
                    startActivity(intent);
                } else if (position == 9){
                    intent.putExtra("region", "paldea");
                    startActivity(intent);
                }
            }
        });
    }
}