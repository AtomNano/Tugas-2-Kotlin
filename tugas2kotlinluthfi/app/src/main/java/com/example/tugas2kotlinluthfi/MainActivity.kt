package com.example.tugas2kotlinluthfi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtName = findViewById<TextInputEditText>(R.id.txtName)
        val txtPassword = findViewById<TextInputEditText>(R.id.txtPassword)
        val btnLogin = findViewById<Button>(R.id.btnlogin)

        btnLogin.setOnClickListener {
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
