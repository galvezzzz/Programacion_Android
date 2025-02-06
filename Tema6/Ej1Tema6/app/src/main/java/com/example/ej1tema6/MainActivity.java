package com.example.ej1tema6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar Fragment1 en el primer contenedor
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer1, new Fragment1())
                .commit();

        // Cargar Fragment2 en el segundo contenedor
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer2, new Fragment2())
                .commit();
    }
}