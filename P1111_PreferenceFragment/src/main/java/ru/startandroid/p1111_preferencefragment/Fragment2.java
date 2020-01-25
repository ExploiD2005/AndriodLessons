package ru.startandroid.p1111_preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class Fragment2 extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref2);
    }

}