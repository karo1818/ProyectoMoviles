package com.example.proyecto.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "usuarios";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT NOT NULL, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL)";


    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public long insert(String username, String password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // Eliminar la tabla si ya existe
        db.execSQL(CREATE_TABLE); // Crear la nueva tabla
        ContentValues values1 = new ContentValues();
        values1.put(MyDatabaseHelper.COLUMN_USERNAME, "user1");
        values1.put(MyDatabaseHelper.COLUMN_PASSWORD, "1");
        db.insert(MyDatabaseHelper.TABLE_NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(MyDatabaseHelper.COLUMN_USERNAME, "user2");
        values2.put(MyDatabaseHelper.COLUMN_PASSWORD, "1");
        db.insert(MyDatabaseHelper.TABLE_NAME, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(MyDatabaseHelper.COLUMN_USERNAME, "user3");
        values3.put(MyDatabaseHelper.COLUMN_PASSWORD, "1");
        db.insert(MyDatabaseHelper.TABLE_NAME, null, values3);
    }



}
