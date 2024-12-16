package com.example.inicialespokemon.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inicialespokemon.R;

public class Region extends AppCompatActivity {

    public void resetImages(ImageView imagen1, ImageView imagen2, ImageView imagen3){
        imagen1.setImageResource(0);
        imagen2.setImageResource(0);
        imagen3.setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciales);

        ImageView imagen1 = findViewById(R.id.inicial1);
        ImageView imagen2 = findViewById(R.id.inicial2);
        ImageView imagen3 = findViewById(R.id.inicial3);
        ImageView btnVolver = findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        String cadena = extras.getString("region");

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Region.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if (cadena.equals("kanto")) {
            imagen1.setImageResource(R.drawable.bulbasur);
            imagen2.setImageResource(R.drawable.charmander);
            imagen3.setImageResource(R.drawable.squirtle);
        } else if (cadena.equals("johto")) {
            imagen1.setImageResource(R.drawable.chikorita);
            imagen2.setImageResource(R.drawable.cyndaquil);
            imagen3.setImageResource(R.drawable.totodile);
        }else if (cadena.equals("hoenn")) {
            imagen1.setImageResource(R.drawable.treecko);
            imagen2.setImageResource(R.drawable.torchic);
            imagen3.setImageResource(R.drawable.mudkip);
        }else if (cadena.equals("sinnoh")) {
            imagen1.setImageResource(R.drawable.turtwig);
            imagen2.setImageResource(R.drawable.chimchar);
            imagen3.setImageResource(R.drawable.piplup);
        }else if (cadena.equals("teselia")) {
            imagen1.setImageResource(R.drawable.snivy);
            imagen2.setImageResource(R.drawable.tepig);
            imagen3.setImageResource(R.drawable.oshawott);
        }else if (cadena.equals("kalos")) {
            imagen1.setImageResource(R.drawable.chespin);
            imagen2.setImageResource(R.drawable.fennekin);
            imagen3.setImageResource(R.drawable.froakie);
        }else if (cadena.equals("alola")) {
            imagen1.setImageResource(R.drawable.rowlet);
            imagen2.setImageResource(R.drawable.litten);
            imagen3.setImageResource(R.drawable.popplio);
        }else if (cadena.equals("galar")) {
            imagen1.setImageResource(R.drawable.grookey);
            imagen2.setImageResource(R.drawable.scorbunny);
            imagen3.setImageResource(R.drawable.sobble);
        }else if(cadena.equals("paldea")){
            imagen1.setImageResource(R.drawable.sprigatito);
            imagen2.setImageResource(R.drawable.fuecoco);
            imagen3.setImageResource(R.drawable.quaxly);
        }

    }
}
