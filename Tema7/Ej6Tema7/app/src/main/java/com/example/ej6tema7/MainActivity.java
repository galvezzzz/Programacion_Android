package com.example.ej6tema7;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);
        TextView textView = findViewById(R.id.textView);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt", Context.MODE_PRIVATE));
                    miFichero.write(editText.getText().toString());
                    miFichero.close();
                    editText.setText("");
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al escribir fichero en memoria interna: " + ex.getMessage());
                }
            }
        });


        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    textView.setText(miFichero.readLine());
                    miFichero.close();
                } catch (Exception e) {
                    Log.e("Ficheros", "Error al leer desde la memoria interna: " + e.getMessage());
                }
            }
        });

    }
}