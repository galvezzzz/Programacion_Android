package com.example.act2t5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
2. Realiza una aplicación cuya actividad tenga objetos dentro de un LinearLayout
vertical, el primero un ListView y el segundo un TextView. Rellena el ListView
con el nombre de 10 series. Cuando se ejecute el TextView, debe tomar el
nombre de elemento tocado del listado.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaro ListView
        ListView listado = findViewById(R.id.series);

        // Declaro fuente de datos (array, ArrayList...)
        final String datos[] = {"From", "LCDP", "Vikingos", "Naruto", "Demon Slayer", "Breaking Bad", "The Last Dance", "Dark", "Dragon Ball Z", "Attack On Titan"};

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
                //Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(posicion).toString(), Toast.LENGTH_SHORT).show();
                TextView textView = findViewById(R.id.textView);
                textView.setText(adapterView.getAdapter().getItem(posicion).toString());
            }
        });

    }
}