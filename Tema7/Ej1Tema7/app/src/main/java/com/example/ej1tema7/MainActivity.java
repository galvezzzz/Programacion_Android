package com.example.ej1tema7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        TextView text1 = findViewById(R.id.txt1);
        TextView text2 = findViewById(R.id.txt2);
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);
        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Clave1",editText1.getText().toString());
                editor.putString("Clave2",editText2.getText().toString());
                editor.commit();

                editText1.setText("");
                editText2.setText("");
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto1 = prefs.getString("Clave1",editText1.getText().toString());
                String texto2 = prefs.getString("Clave2",editText2.getText().toString());
                text1.setText(texto1);
                text2.setText(texto2);
            }
        });


    }
}