package com.example.ejemplomenuopcionesjava;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int MnOp1 = 1;
    private static final int MnOp2 = 2;
    private static final int MnOp3 = 3;

    private static final int MnOp2_1 = 4;
    private static final int MnOp2_2 = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    // Versión sin submenús
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        menu.add(Menu.NONE, MnOp1,Menu.NONE,"Opción A desde Java");
//        menu.add(Menu.NONE, MnOp2,Menu.NONE,"Opción B desde Java");
//        menu.add(Menu.NONE, MnOp3,Menu.NONE,"Opción C desde Java");
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case MnOp1:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//
//            case MnOp2:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//
//            case MnOp3:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    // Versión con submenús
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, MnOp1,Menu.NONE,"Opción A desde Java");

        SubMenu subMenu = menu.addSubMenu(Menu.NONE, MnOp2, Menu.NONE, "Opción B desde Java");
        subMenu.add(Menu.NONE, MnOp2_1, Menu.NONE, "Opción B.1 desde Java");
        subMenu.add(Menu.NONE, MnOp2_2, Menu.NONE, "Opción B.2 desde Java");

        menu.add(Menu.NONE, MnOp3,Menu.NONE,"Opción C desde Java");
        return true;
    }

        @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case MnOp1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case MnOp2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case MnOp3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case MnOp2_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case MnOp2_2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}