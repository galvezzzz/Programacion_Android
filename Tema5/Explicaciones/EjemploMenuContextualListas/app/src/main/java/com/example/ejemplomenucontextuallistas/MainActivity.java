package com.example.ejemplomenucontextuallistas;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupero el listado
        listado = findViewById(R.id.listado);

        // Creo los datos
        ArrayList<String> datos = new ArrayList<>();
        datos.add("Elemento 1");
        datos.add("Elemento 2");
        datos.add("Elemento 3");

        // Creo el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datos);
        listado.setAdapter(adapter);
        registerForContextMenu(listado);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        // Obtengo el elemento del listado pulsado
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        // Le pongo al menú contextual un título
        menu.setHeaderTitle(listado.getAdapter().getItem(info.position).toString().toUpperCase());

        // Compruebo el elemento pulsado para ver qué menú inflo
        switch(info.position){
            case 0:
                inflater.inflate(R.menu.menuc1, menu);
                break;
            case 1:
                inflater.inflate(R.menu.menuc2, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String texto;
        int id = item.getItemId();

        if ( id == R.id.mcOp1 || id == R.id.mcOp2 || id == R.id.mcOp3 || id == R.id.menu2){
            texto = item.getTitle().toString();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }

        // Obtengo info sobre el que hemos desplegado en el menú
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pulsado = info.position;
        texto = listado.getItemAtPosition(pulsado).toString();
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}