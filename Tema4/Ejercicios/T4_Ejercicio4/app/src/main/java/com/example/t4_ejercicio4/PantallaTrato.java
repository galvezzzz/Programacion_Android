package com.example.t4_ejercicio4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class PantallaTrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_trato);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton imageButton = findViewById(R.id.imagen);
        TextView txtFantasmas = findViewById(R.id.txtFantasmas);
        txtFantasmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaTrato.this, MainActivity.class);
                startActivity(intent);
                imageButton.setImageResource(R.drawable.calabaza);
            }
        });

        TextView txtCalabazas= findViewById(R.id.txtCalabazas);
        txtCalabazas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaTrato.this, MainActivity.class);
                startActivity(intent);
                imageButton.setImageResource(R.drawable.fantasma);
            }
        });
    }
}