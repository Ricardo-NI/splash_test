package com.example.externalconnection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CrudCompletoDB";

    public DataBaseAdapter( Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       // String sql = "CREATE TABLE contato ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT)";
       // db.execSQL(sql);

        db.execSQL(ScriptSQL.getCreateTreinos());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
