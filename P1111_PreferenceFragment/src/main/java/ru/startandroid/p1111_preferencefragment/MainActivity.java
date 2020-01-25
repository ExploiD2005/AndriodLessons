package ru.startandroid.p1111_preferencefragment;

//import android.support.v7.app.AppCompatActivity;
//import android.app.Activity;
//import android.os.Bundle;

//public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        getFragmentManager().beginTransaction()
//                .replace(android.R.id.content, new Fragment1()).commit();
//
//    }
//}

import java.util.List;

import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {

    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
    }
}