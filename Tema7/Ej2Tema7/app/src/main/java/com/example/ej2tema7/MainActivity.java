package com.example.ej2tema7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
        SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        Button btnDefinir = findViewById(R.id.btnDefinir);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);

        btnDefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Opciones.class);
                startActivity(intent);
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("","Opción 1: " + pref.getBoolean("opcion1",false));
                Log.i("","Opción 2: " + pref.getString("opcion2",""));
                Log.i("", "Opción 3:" + pref.getString("opcion3",""));

            }
        });
    }
}