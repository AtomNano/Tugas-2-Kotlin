package com.example.tugas2kotlinluthfi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txtName = findViewById<EditText>(R.id.txtName)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val btnInput = findViewById<Button>(R.id.btnInput)

        btnInput.setOnClickListener {
            val username = txtName.text.toString()
            val password = txtPassword.text.toString()

            if (username == "admin" && password == "123456") {

                val intent = Intent(this, welcome::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}