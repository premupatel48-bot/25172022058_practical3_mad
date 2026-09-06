package com.example.a25172022058_practical3_mad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.editTextText)
        val passwordEditText = findViewById<EditText>(R.id.editTextText2)
        val login1button = findViewById<Button>(R.id.login1button)

        login1button.setOnClickListener {

            val enteredEmail = emailEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredEmail == "abc@gmail.com" && enteredPassword == "123") {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Invalid Email or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}