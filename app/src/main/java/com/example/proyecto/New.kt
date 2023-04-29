package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class New : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val cancelbtn = findViewById<Button>(R.id.cancelbtn)


        cancelbtn.setOnClickListener {

            val intent = Intent(this, ToDoList::class.java)
            startActivity(intent)
    }
}
}