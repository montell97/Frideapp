package com.example.montell.frideapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by montell on 30/07/2018.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Item.db";
    public static final String TABLE_NAME ="Item_table";
    public static final String COl_1 ="ID";
    public static final String COl_2 ="ITEM_NAME";
    public static final String COl_3 ="Description";
    public static final String COl_4 ="Expiry_date";
    public static final String COl_5 ="Cost";
    public static final String COl_6 ="Quantity";

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table"+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM_NAME TEXT,Description TEXT,Expiry_date DATE,Cost DOUBLE,Quantity INTEGER ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDate(String name,String description,String date, String cost, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2,name);
        contentValues.put(COl_3,description);
        contentValues.put(COl_4,date);
        contentValues.put(COl_5,cost);
        contentValues.put(COl_6,quantity);
     long result=db.insert(TABLE_NAME,null,contentValues);
if (result == -1)
return false;
else
return true;
    }

    public Cursor getAllDate(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from"+ TABLE_NAME,null);
        return result;
    }
}