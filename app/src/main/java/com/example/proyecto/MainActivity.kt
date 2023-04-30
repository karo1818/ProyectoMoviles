package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.proyecto.SQLiteDB.SQLiteOpenHelperManager

class MainActivity : AppCompatActivity() {
    var SQLiteOpenHelperManager = SQLiteOpenHelperManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        SQLiteOpenHelperManager = SQLiteOpenHelperManager(this)
        SQLiteOpenHelperManager.crearTablaUsuarios()


        // Comenta la siguiente línea para evitar duplicar los registros
        // dbHelper.burnedData(dbHelper.writableDatabase)

        val loginButton = findViewById<Button>(R.id.loginbtn)

        loginButton.setOnClickListener {
            val usuarioText = findViewById<EditText>(R.id.usuariotext)
            val passwordText = findViewById<EditText>(R.id.passwordtext)

            val usuario = usuarioText.text.toString()
            val password = passwordText.text.toString()

            validarUsuario(usuario, password)

            // Crear la tabla de usuarios



        }
    }

    fun validarUsuario(usuario: String, password: String) {
        val db = SQLiteOpenHelperManager.readableDatabase


        val insertQuery1 = "INSERT INTO usuarios (nombre, password) VALUES ('Gabriel', 1111);"
        val insertQuery2 = "INSERT INTO usuarios (nombre, password) VALUES ('Keisy', 2222);"
        val insertQuery3 = "INSERT INTO usuarios (nombre, password) VALUES ('Raquel', 3333);"
        val insertQuery4 = "INSERT INTO usuarios (nombre, password) VALUES ('Karo', 4444);"

        db.execSQL(insertQuery1)
        db.execSQL(insertQuery2)
        db.execSQL(insertQuery3)
        db.execSQL(insertQuery4)

        val cursor = db.rawQuery(
            "SELECT * FROM usuarios WHERE nombre=? AND password=?",
            arrayOf(usuario, password)
        )
        if (cursor.moveToFirst()) {
            val intent = Intent(this, ToDoList::class.java)
            startActivity(intent)
        } else {
            AlertDialog.Builder(this)
                .setTitle("Error de autenticación")
                .setMessage("El usuario o la contraseña son incorrectos.")
                .setPositiveButton("OK", null)
                .show()
        }
        cursor.close()
    }


}
