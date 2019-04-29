package com.example.listviewapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper{

    private static final String databaseName = "DictionaryDb";
    private static final int dbversion= 1;


    public MyHelper(Context context) {
        super(context, databaseName, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE words " +
                "(" +
                "WordId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Word TEXT," +
                "Meaning TEXT)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db){
        try {
            String query = "insert into Words(Word,Meaning) values('" + word + "','"+ meaning + "')";
            db.execSQL(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
