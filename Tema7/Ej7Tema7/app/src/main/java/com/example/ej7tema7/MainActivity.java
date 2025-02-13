package com.example.ej7tema7;

import static android.os.Environment.DIRECTORY_RINGTONES;

import android.os.Bundle;
import android.os.Environment;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        // ESCRIBIR
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Obtengo la ruta del directorio raíz
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                    OutputStreamWriter fout =
                            new OutputStreamWriter(new FileOutputStream(f));
                    fout.write(editText.getText().toString());
                    editText.setText("");
                    fout.close();
                }
                catch (Exception ex){
                    Log.e("Ficheros","Error al escribir en la tarjeta SD");
                }
            }
        });

        // LEER
        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File ruta_sd = getExternalFilesDir(DIRECTORY_RINGTONES);
                    File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            new FileInputStream(f)));
                    textView.setText(fin.readLine());
                    fin.close();
                }
                catch (Exception ex){
                    Log.e("Ficheros","Error al leer en la tarjeta SD");
                }
            }
        });
    }
}