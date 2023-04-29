package com.example.proyecto
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.proyecto.DB.MyDatabaseHelper

class MainActivity : AppCompatActivity() {
    var dbHelper = MyDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginbtn)

        loginButton.setOnClickListener {
            val usuarioText = findViewById<EditText>(R.id.usuariotext)
            val passwordText = findViewById<EditText>(R.id.passwordtext)

            val usuario = usuarioText.text.toString()
            val password = passwordText.text.toString()

            validarUsuario(usuario, password)
        }
    }

    fun validarUsuario(usuario: String, password: String) {
        if (usuario == "1" && password == "1") {
            val intent = Intent(this, ToDoList::class.java)
            startActivity(intent)
        } else {
            AlertDialog.Builder(this)
                .setTitle("Error de autenticación")
                .setMessage("El usuario o la contraseña son incorrectos.")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}




