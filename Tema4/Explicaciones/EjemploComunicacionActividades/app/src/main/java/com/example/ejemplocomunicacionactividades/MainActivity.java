package com.example.ejemplocomunicacionactividades;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblResultado = findViewById(R.id.lblResultado);

        // Recogemos los datos de la actividad B (CondicionesUso)
        ActivityResultLauncher resultLauncher =
                registerForActivityResult(
                        new
                );
        // Invocamos CondicionesUso
        final EditText etNombre = findViewById(R.id.etNombre);
        final Button btnVerificar = findViewById(R.id.btnVerificar);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etNombre.getText().toString();

                // Creo el intent y le paso los datos
                Intent intent_condiciones = new Intent(MainActivity.this, CondicionesUso.class);
                intent_condiciones.putExtra("usuario", usuario);
                startActivity(intent_condiciones);

            }
        });
    }
}