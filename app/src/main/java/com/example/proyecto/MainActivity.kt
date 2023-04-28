package com.example.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usuarioText = findViewById<EditText>(R.id.usuariotext)
        val passwordText = findViewById<EditText>(R.id.passwordtext)
        val usuario = usuarioText.text.toString()
        val password = passwordText.text.toString()

        val loginButton = findViewById<Button>(R.id.loginbtn)

        loginButton.setOnClickListener {

            val usuarioText = findViewById<EditText>(R.id.usuariotext)
            val passwordText = findViewById<EditText>(R.id.passwordtext)

            val usuario = usuarioText.text.toString()
            val password = passwordText.text.toString()

            if (usuario == "123" && password == "123") {
                val intent = Intent(this, ToDoList::class.java)
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Contraseña o nombre de usuario incorrecto")
                    .setPositiveButton("OK") { dialog, which ->
                        // Código a ejecutar cuando se presione el botón OK
                    }
                builder.create().show()
            }
        }

    }
}
