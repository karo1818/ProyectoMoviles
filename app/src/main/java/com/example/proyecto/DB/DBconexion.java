package com.example.proyecto.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBconexion extends SQLiteOpenHelper {

    private static final String DB_NAME="proyecto.db";
    private static final int DB_VERSION = 1;

    public DBconexion(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBmanager.CREATE_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +DBmanager.TABLA_CURSOS);
    }
}
