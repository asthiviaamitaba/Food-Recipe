package com.example.resepmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val backBtn: ImageView = findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            val intentLogin = Intent (this, WelcomeActivity::class.java)
            startActivity(intentLogin)
        }

        val register: Button = findViewById(R.id.R_btn_1)
        register.setOnClickListener {
            val intentLogin = Intent (this, WelcomeActivity::class.java)
            startActivity(intentLogin)
        }

        val login: TextView = findViewById(R.id.logintext)
        login.setOnClickListener {
            val intentLogin = Intent (this, LoginActivity::class.java)
            startActivity(intentLogin)
        }

    }
}