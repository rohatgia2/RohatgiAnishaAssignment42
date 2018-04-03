package com.example.rohat.rohatgianishaassignment42;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WordPair.db";
    private static final String TABLE_NAME = "WordPair";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ORIGINALWORD = "originalWord";
    private static final String COLUMN_ANTONYMWORD = "antonymWord";
    private static final String COLUMN_SEARCHWORD = "searchWord";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table WordPair (id integer primary key not null auto_increment ," +
            "originalWord text not null, antonymWord text not null, searchWord not null)";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertWordPair(WordPair w)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ORIGINALWORD, w.getOriginalWord());
        values.put(COLUMN_ANTONYMWORD, w.getAntonymWord());
        values.put(COLUMN_SEARCHWORD, w.getSearchWord());

        db.insert(TABLE_NAME , null , values );

    }

    public String searchSearchWord(String antonym)
    {
        db = this.getReadableDatabase();
        String query = "select antonym, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do
            {
                a = cursor.getString(0);
                if(a.equals(antonym)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
