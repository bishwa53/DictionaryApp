package com.example.listviewapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listviewapp.helper.MyHelper;

public class SQLLiteAtivity extends AppCompatActivity {

    EditText etWord,etDefinition;
    Button addWord;
    Button btnOpenDictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllite_ativity);


        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        addWord = findViewById(R.id.btnAddWord);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqliteDb = myHelper.getWritableDatabase();

        addWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( myHelper.InsertData(etWord.getText().toString(), etDefinition.getText().toString(), sqliteDb ) ){
                    Toast.makeText(SQLLiteAtivity.this,"Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SQLLiteAtivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
