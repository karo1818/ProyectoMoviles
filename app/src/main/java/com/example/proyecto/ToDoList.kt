package com.example.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        val nuevatareabtn = findViewById<ImageView>(R.id.nuevatareabtn)


        nuevatareabtn.setOnClickListener {

            val intent = Intent(this, New::class.java)
            startActivity(intent)
        }
    }
}
