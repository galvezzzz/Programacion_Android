package com.example.practicaandroid.main;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicaandroid.R;
import com.example.practicaandroid.adaptador.Adaptador;
import com.example.practicaandroid.spinnerPersonalizado.SpinnerPersonalizado;
import com.example.practicaandroid.spinnerPersonalizado.Datos;
import com.example.practicaandroid.bbdd.Contactos;
import com.example.practicaandroid.bbdd.ContentProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Adaptador adaptador;
    private Spinner spinner;
    private Button btnAnadir;
    private Button btnCancelar;
    private Button btnModificar;
    private ListView listViewAvatar;
    private EditText editNombre;
    private EditText editTelefono;
    private TextView txtNombre;
    private TextView txtTelefono;
    private TextView txtSpinner;
    private int avatarPos = 0;
    private int contactoPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contactos contactosBBDD = new Contactos(this, "Contactos", null, 1);
        SQLiteDatabase database = contactosBBDD.getWritableDatabase();

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtSpinner = findViewById(R.id.txtSpinner);

        ImageButton imagenContactos = findViewById(R.id.imagenContactos);

        btnAnadir = findViewById(R.id.btnAñadir);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnModificar = findViewById(R.id.btnModificar);

        editNombre = findViewById(R.id.editNombre);
        editTelefono = findViewById(R.id.editTelefono);

        listViewAvatar = findViewById(R.id.listViewAvatar);
        registerForContextMenu(listViewAvatar);

        spinner = findViewById(R.id.spinner);

        // Iniciar spinner
        Datos[] datosSpinners = new Datos[] {
                new Datos(R.drawable.batman),
                new Datos(R.drawable.capi),
                new Datos(R.drawable.hulk),
                new Datos(R.drawable.deadpool),
                new Datos(R.drawable.furia),
                new Datos(R.drawable.ironman),
                new Datos(R.drawable.lobezno),
                new Datos(R.drawable.spiderman),
                new Datos(R.drawable.thor),
                new Datos(R.drawable.wonderwoman),
        };

        iniciarListView();
        SpinnerPersonalizado adaptador = new SpinnerPersonalizado(this,datosSpinners);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                avatarPos = ((Datos) parent.getItemAtPosition(position)).getImagen();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imagenContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetEditText();
                mostrarElementos();
                btnModificar.setVisibility(View.INVISIBLE);
            }
        });

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ContentProvider.Contactos.NOMBRE, editNombre.getText().toString());
                values.put(ContentProvider.Contactos.TELEFONO, editTelefono.getText().toString());
                values.put(ContentProvider.Contactos.AVATAR, avatarPos);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.insert(ContentProvider.CONTENT_URI, values);
                resetEditText();
                iniciarListView();
                ocultarElementos();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarElementos();
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ContentProvider.Contactos.NOMBRE, editNombre.getText().toString());
                values.put(ContentProvider.Contactos.TELEFONO, editTelefono.getText().toString());
                values.put(ContentProvider.Contactos.AVATAR, avatarPos);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.update(ContentProvider.CONTENT_URI,values, ContentProvider.Contactos._ID + "=" + contactoPos, null);
                resetEditText();
                iniciarListView();
                ocultarElementos();
            }
        });

        listViewAvatar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contactoPos = MainActivity.this.adaptador.getItem(position).getIndice();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        com.example.practicaandroid.adaptador.Datos contacto = adaptador.getItem(position);
        contactoPos = contacto.getIndice();

        if(item.getItemId() == R.id.menuBorrar) {
            ContentResolver contentResolver = getContentResolver();
            contentResolver.delete(ContentProvider.CONTENT_URI, ContentProvider.Contactos._ID + "=" + contactoPos, null);
            iniciarListView();
            return true;

        }else if (item.getItemId() == R.id.menuActualizar) {
            editNombre.setText(contacto.getNombre());
            int posicionAvatar = posicionAvatar(contacto.getAvatar());

            spinner.setSelection(posicionAvatar);
            editTelefono.setText(contacto.getTelefono());

            mostrarElementos();
            iniciarListView();

            return true;
        }
        return super.onContextItemSelected(item);
    }

    // Funciones
    private void ocultarElementos(){
        btnAnadir.setVisibility(View.GONE);
        btnModificar.setVisibility(View.GONE);
        btnCancelar.setVisibility(View.GONE);
        txtTelefono.setVisibility(View.GONE);
        txtNombre.setVisibility(View.GONE);
        txtSpinner.setVisibility(View.GONE);
        editNombre.setVisibility(View.GONE);
        editTelefono.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);
    }

    private void mostrarElementos(){
        btnAnadir.setVisibility(View.VISIBLE);
        btnModificar.setVisibility(View.VISIBLE);
        btnCancelar.setVisibility(View.VISIBLE);
        txtTelefono.setVisibility(View.VISIBLE);
        txtNombre.setVisibility(View.VISIBLE);
        txtSpinner.setVisibility(View.VISIBLE);
        editNombre.setVisibility(View.VISIBLE);
        editTelefono.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.VISIBLE);
    }

    private void resetEditText() {
        editNombre.setText("");
        editTelefono.setText("");
    }

    private int posicionAvatar(int avatar) {
        SpinnerPersonalizado adapter = (SpinnerPersonalizado) spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).getImagen() == avatar) {
                return i;
            }
        }
        return 0;
    }

    private void iniciarListView() {
        String[] campos = new String[]{
                ContentProvider.Contactos._ID,
                ContentProvider.Contactos.NOMBRE,
                ContentProvider.Contactos.TELEFONO,
                ContentProvider.Contactos.AVATAR,
        };

        Uri versionesUri = ContentProvider.CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(versionesUri, campos, null,null,null);
        com.example.practicaandroid.adaptador.Datos importDatos;

        ArrayList<com.example.practicaandroid.adaptador.Datos> datos = new ArrayList<>();
        adaptador = new Adaptador(this,datos);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int campoId = cursor.getColumnIndex(ContentProvider.Contactos._ID);
                int campoNombre = cursor.getColumnIndex(ContentProvider.Contactos.NOMBRE);
                int campoTelefono = cursor.getColumnIndex(ContentProvider.Contactos.TELEFONO);
                int campoAvatar =cursor.getColumnIndex(ContentProvider.Contactos.AVATAR);

                do {
                    int id = cursor.getInt(campoId);
                    String nombre = cursor.getString(campoNombre);
                    String telefono=cursor.getString(campoTelefono);
                    int avatar = cursor.getInt(campoAvatar);
                    importDatos = new com.example.practicaandroid.adaptador.Datos(id,nombre,telefono,avatar);
                    datos.add(importDatos);
                } while (cursor.moveToNext());
            }
        }
        listViewAvatar.setAdapter(adaptador);
    }
}