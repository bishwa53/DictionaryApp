package com.example.listviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView lvCountries;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        dictionary.put("Nepal","Kathmandu");
        dictionary.put("India","New Delhi");
        dictionary.put("China","Bejing");
        dictionary.put("Japan","Tokya");

        lvCountries = findViewById(R.id.lvCountries);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet()));
        lvCountries.setAdapter(adapter);

        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(country);
                Log.d(TAG, capital);
            }
        });
    }
}