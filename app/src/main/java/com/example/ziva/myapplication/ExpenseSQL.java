package com.example.ziva.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExpenseSQL extends SQLiteOpenHelper
{
    private final static String DB = "DATA_expense.db";
    private final static String TB = "Expense";//資料表
    private final static int VS = 1;
    private final static String COL_date = "_date";
    private final static String COL_income = "_income";
    private final static String COL_expense = "_expense";
    private static final String CREATE_TABLE = "CREATE TABLE "+TB+
            " (_date TEXT PRIMARY KEY,_income INTEGER,_expense INTEGER);";
    private static Context context;

    public ExpenseSQL(Context context) {
        super(context, DB, null, VS);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE" + TB;
        db.execSQL(SQL);
    }

    public long addData(String _date, String _income, String _expense)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_date,_date);
        values.put(COL_income,_income);
        values.put(COL_expense,_expense);
        //long result = db.insert(TB,null,values);
        long id = db.insert(ExpenseSQL.TB, null , values);
        return id;
        /*if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }*/
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TB, null);
        return data;
    }

    public void delete()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB,null,null);
        db.execSQL("delete from "+ TB);
//        db.execSQL("TRUNCATE table " + TB);
        db.close();
    }

}
