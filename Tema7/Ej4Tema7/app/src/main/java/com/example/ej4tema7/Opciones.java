package com.example.ej4tema7;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

public class Opciones extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.opciones, rootKey);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}