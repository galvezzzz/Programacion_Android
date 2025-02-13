package com.example.examenalbertogalvez;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // SPINNER
        Spinner listadoSpinner = (Spinner) findViewById(R.id.spinner);
        final String[] datosSpinner = {"Shonen","Shojo"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datosSpinner);
        listadoSpinner.setAdapter(adaptadorSpinner);

        // GRIDVIEW
        GridView listadoGrid = (GridView) findViewById(R.id.gridView);
        String[] datosGrid = {"Guardianes de la noche","Ataque a los titanes","Naruto","Los sieste pecados capitales","Desaparecido"};
        ArrayAdapter<String> adaptadorGrid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datosGrid);
        listadoGrid.setAdapter(adaptadorGrid);

        // LISTVIEW
        ListView listadoList = (ListView) findViewById(R.id.listView);
        final String[] datosList = {"Mi vecino Totoro","El castillo ambulante","El viaje de Chihiro", "Susurros del corazón","Haru en el reino de los gatos"};
        ArrayAdapter<String> adaptadorList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosList);
        listadoList.setAdapter(adaptadorList);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView = findViewById(R.id.tituloTxt);
        Spinner spinner = findViewById(R.id.spinner);
        ListView listView = findViewById(R.id.listView);
        GridView gridView = findViewById(R.id.gridView);

        Intent actividad2 = new Intent(this,MainActivity2.class);
        if (item.getItemId() > 0) {
            // Reiniciar todo
            textView.setText("");
            listView.setVisibility(View.INVISIBLE);
            gridView.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
        }

        if (item.getItemId() == R.id.MnOp1){
            textView.setText("PELÍCULAS");

        }else if (item.getItemId() == R.id.MnOp2){
            textView.setText("SERIES");
            spinner.setVisibility(View.VISIBLE);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (i == 0){
                        gridView.setVisibility(View.VISIBLE);

                    } else if (i == 1) {
                        gridView.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }else if (item.getItemId() == R.id.MnOp3){
            textView.setText("MANGA");
        }

        // Pulsar Studio Ghibli
        if (item.getItemId() == R.id.MnOp1_1){
            textView.setText("PELÍCULAS");
            listView.setVisibility(View.VISIBLE);
        }

        // Pulsar Clamp
        if (item.getItemId() == R.id.MnOp1_2){
            textView.setText("PELÍCULAS");
        }

        if (item.getItemId() == R.id.MnOp3_1){
            actividad2.putExtra("imagen", "shonen");
            startActivity(actividad2);
        }

        if (item.getItemId() == R.id.MnOp3_2){
            actividad2.putExtra("imagen", "shojo");
            startActivity(actividad2);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        ListView listView = findViewById(R.id.listView);
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                menuInfo;
        menu.setHeaderTitle(listView.getAdapter().getItem(info.position).toString());
        switch (info.position){
            case 0:
                inflater.inflate(R.menu.menu_context,menu);
                return;
            case 1:
                inflater.inflate(R.menu.menu_context, menu);
                return;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.ListaOpA1){
            return true;
        }

        return super.onContextItemSelected(item);
    }

    ActivityResultLauncher resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent!=null){
                            // Código
                        }
                    }
                }
            });


}