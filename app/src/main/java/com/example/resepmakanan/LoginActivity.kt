package com.example.resepmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.postDelayed
import kotlinx.coroutines.delay

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backBtn: ImageView = findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            val intentLogin = Intent (this, WelcomeActivity::class.java)
            startActivity(intentLogin)
        }

        val reg: TextView = findViewById(R.id.regtext)
        reg.setOnClickListener {
            val intentRegister = Intent (this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

        val home: Button = findViewById(R.id.L_btn_1)
        home.setOnClickListener {
            val intentHome = Intent (this, HomeActivity::class.java)
            startActivity(intentHome)
        }

    }
}