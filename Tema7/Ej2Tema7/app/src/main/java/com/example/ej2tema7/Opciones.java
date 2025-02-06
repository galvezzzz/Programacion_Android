package com.example.ej2tema7;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Opciones extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
