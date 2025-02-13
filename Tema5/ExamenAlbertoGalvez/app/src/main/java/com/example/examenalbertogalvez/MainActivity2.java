package com.example.examenalbertogalvez;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manga);

        ImageView imagen = findViewById(R.id.imagen);
        Button btnVolver = findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        String s = extras.getString("imagen");

        if (s.equals("shonen")){
            imagen.setImageResource(R.drawable.kimetsu);
        }else{
            imagen.setImageResource(R.drawable.furuba);
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actividad = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(actividad);
            }
        });

    }
}
