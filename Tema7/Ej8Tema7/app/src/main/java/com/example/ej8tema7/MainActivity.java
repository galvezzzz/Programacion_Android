package com.example.ej8tema7;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


    import static android.os.Environment.DIRECTORY_RINGTONES;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final Spinner spinner = findViewById(R.id.miSpinner);

            ArrayList<Datos> datos = new ArrayList<>();
            datos.add(new Datos(R.drawable.batman));
            datos.add(new Datos(R.drawable.capi));
            datos.add(new Datos(R.drawable.deadpool));
            datos.add(new Datos(R.drawable.furia));
            datos.add(new Datos(R.drawable.hulk));
            datos.add(new Datos(R.drawable.ironman));
            datos.add(new Datos(R.drawable.lobezno));
            datos.add(new Datos(R.drawable.spiderman));
            datos.add(new Datos(R.drawable.thor));
            datos.add(new Datos(R.drawable.wonderwoman));

            AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(datos, this);
            spinner.setAdapter(adapter);


        }
}