package com.example.a25172022058_practical3_mad

import android.widget.EditText
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.AlarmClock
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.weburlbutton).setOnClickListener {
            val url = findViewById<EditText>(R.id.weburleditTextText).text.toString()

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
//this code of kotlin still open the Google url even we enter any others
//        findViewById<Button>(R.id.weburlbutton).setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
//            startActivity(intent)
//        }
        findViewById<Button>(R.id.phonenobutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9898573586"))
            startActivity(intent)
        }
        findViewById<Button>(R.id.callogbutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("content://call_log/calls")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.gallarybutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = "image/*"
                data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.camerabutton).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        findViewById<Button>(R.id.alarmbutton).setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }
        val loginButton = findViewById<Button>(R.id.loginbutton)

        loginButton.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
//        findViewById<Button>(R.id.loginbutton).setOnClickListener {
//            val intent = Intent(this, login::class.java)
//            startActivity(intent)
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}