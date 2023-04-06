package com.example.aptechclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },SPLASH_TIME_OUT)

    }
}