package com.example.practicaandroid.bbdd;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentProvider extends android.content.ContentProvider {

    private static final String AUTHORITY = "com.example.practicaandroid";
    private static final String URI = "content://" + AUTHORITY + "/Contactos";
    public static final Uri CONTENT_URI = Uri.parse(URI);
    private static final int CONTACTOS = 1;
    private static final int ID_CONTACTOS = 2;
    private static final UriMatcher URI_MATCHER;
    private com.example.practicaandroid.bbdd.Contactos contactos;

    private static final String NOMBRE_DATABASE = "DBContactos";
    private static final int VERSION = 1;
    private static final String TABLA_CONTACTOS = "Contactos";

    static{
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY,"Contactos",CONTACTOS);
        URI_MATCHER.addURI(AUTHORITY,"Contactos/#", ID_CONTACTOS);
    }

    public static final class Contactos implements BaseColumns {
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String AVATAR = "avatar";
    }

    @Override
    public boolean onCreate() {
        contactos = new com.example.practicaandroid.bbdd.Contactos(getContext(), NOMBRE_DATABASE, null, VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String where = selection;

        if (URI_MATCHER.match(uri)== ID_CONTACTOS){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = contactos.getWritableDatabase();
        Cursor cursor = db.query(TABLA_CONTACTOS, projection, where, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);

        switch (match) {
            case CONTACTOS:
                return "vmd.android.cursor.dir/vmd.com.example.Contactos";
            case ID_CONTACTOS:
                return "vmd.android.cursor.item/vmd.com.example.Contactos";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long regId;

        SQLiteDatabase db = contactos.getWritableDatabase();
        regId = db.insert(TABLA_CONTACTOS, null, values);
        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);
        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;
        String where = selection;

        if (URI_MATCHER.match(uri)== ID_CONTACTOS){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = contactos.getWritableDatabase();
        cont = db.delete(TABLA_CONTACTOS,where,selectionArgs);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int cont;
        String where = selection;

        if (URI_MATCHER.match(uri)== ID_CONTACTOS){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = contactos.getWritableDatabase();
        cont = db.update(TABLA_CONTACTOS,values,where,selectionArgs);

        return cont;
    }
}
