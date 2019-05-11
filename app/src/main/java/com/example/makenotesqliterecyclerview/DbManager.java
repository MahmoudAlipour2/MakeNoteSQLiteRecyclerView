package com.example.makenotesqliterecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {
    private static final String DatabaseName = "note.db";
    private static final int Version = 1;
    private static final String TableName = "note_list";
    private static final String dID = "id";
    private static final String dTitle = "title";
    private static final String dContext = "context";


    public DbManager(Context cnt) {
        super(cnt, DatabaseName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase cdb) {
// db Creation!
        String cQuery =
                " CREATE TABLE " + TableName + " (" + dID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + dTitle + " VARCHAR, " + dContext + " VARCHAR );";

        cdb.execSQL(cQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase cdb, int i, int il) {

    }



    public void insertText(Text itxt) {
        SQLiteDatabase idb = this.getWritableDatabase();
        ContentValues icv = new ContentValues();
        icv.put(dID, itxt.tID);
        icv.put(dTitle, itxt.tTitle);
        icv.put(dContext, itxt.tContext);

        idb.insert(TableName, null, icv);
        idb.close();
    }



}
