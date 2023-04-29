package com.example.proyecto.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBmanager{

    public static final String TABLA_CURSOS="cursos";
    public static final String nombre="nombre";
    public static final String id="id";
    public static final String CREATE_CURSOS="CREATE TABLE cursos(nombre text not null, id integer not null);";
    private DBconexion conexion;
    private SQLiteDatabase basededatos;

    public DBmanager(Context context) {
        conexion = new DBconexion(context);

    }

    public DBmanager open()throws SQLException{
        basededatos = conexion.getWritableDatabase();
        return this;
    }

    public  void close(){
        conexion.close();
    }

    public void insertarCurso (String id, String nombre){
        ContentValues contentValues = new ContentValues();
        contentValues.put(id,id);
        contentValues.put(nombre,nombre);
        this.basededatos.insert(TABLA_CURSOS,null,contentValues);
    }

}
