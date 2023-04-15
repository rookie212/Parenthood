package com.humber.parenthood;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreference {
    private Context context;
    SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    public SharedPreference(Context context2) {
        context = context2;
        preferences = context2.getSharedPreferences(context2.getPackageName(), 0);
        editor = preferences.edit();
    }


    public boolean getBoolean(String str) {
        return preferences.getBoolean(str, false);
    }

    public void addBoolean(String str, boolean z) {
        editor = preferences.edit();
        editor.putBoolean(str, z);
        editor.commit();
    }
}