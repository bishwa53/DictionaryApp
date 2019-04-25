package com.example.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {

    EditText etWord,etDefinition;
    Button addWord;
    Button btnOpenDictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        addWord = findViewById(R.id.btnAddWord);

        addWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

        //open dictionary button
        btnOpenDictionary = findViewById(R.id.btnOpenDictionary);
        btnOpenDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });

    }

    private void Save(){
        try {
            PrintStream ps = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            ps.println(etWord.getText().toString() + "=" + etDefinition.getText().toString());
            Toast.makeText(this,"Saved to "+ getFilesDir(), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
