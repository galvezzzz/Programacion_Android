package com.example.ejemplosubmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opcion = item.getItemId();

        if (opcion == R.id.MnOp1 || opcion == R.id.MnOp2 || opcion == R.id.MnOp3 ){
            Toast.makeText(this, "Menú" + item.getTitle(), Toast.LENGTH_SHORT).show();
        }else if (opcion == R.id.MnOp2_1 || opcion == R.id.MnOp2_2){
            Toast.makeText(this, "Submenú" + item.getTitle(), Toast.LENGTH_SHORT).show();
        }else{
            return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}