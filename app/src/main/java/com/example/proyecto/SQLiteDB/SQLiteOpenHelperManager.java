package com.example.proyecto.SQLiteDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;



public class SQLiteOpenHelperManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "proyecto";
    private static final int DATABASE_VERSION = 1;

    public SQLiteOpenHelperManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE usuarios(" +
                        "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nombre TEXT NOT NULL," +
                        "password TEXT NOT NULL)"
        );

        //sqLiteDatabase.execSQL(
        //        "CREATE TABLE cursos(" +
         //               "id_curso INTEGER PRIMARY KEY AUTOINCREMENT," +
          //              "nombre TEXT NOT NULL," +
         //               "id_usuario INTEGER NOT NULL," +
       //                 "FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario))"
      //  );


        burnedData(sqLiteDatabase);

    }


    public void crearTablaUsuarios() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS usuarios"); // eliminamos la tabla existente si existe
        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY, nombre TEXT, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    private void burnedData(SQLiteDatabase sqLiteDatabase) {


        //USUARIOS----------------------------------------------------------------------------------
        //sqLiteDatabase.execSQL("insert into usuarios (nombre, password) values ('Gabriel',1111)");
       // sqLiteDatabase.execSQL("insert into usuarios (nombre, password) values ('Keisy',2222)");
       // sqLiteDatabase.execSQL("insert into usuarios (nombre, password) values ('Raquel',3333)");
       // sqLiteDatabase.execSQL("insert into usuarios (nombre, password) values ('Karo',4444)");

        //Cursos----------------------------------------------------------------------------------
       // sqLiteDatabase.execSQL("insert into cursos (nombre) values ('Paradigmas')");
       // sqLiteDatabase.execSQL("insert into cursos (nombre) values ('Moviles')");
       // sqLiteDatabase.execSQL("insert into cursos (nombre) values ('Videojuegos')");
       // sqLiteDatabase.execSQL("insert into cursos (nombre) values ('Sistemas')");



    }
}
