package com.example.aptechclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().add(R.id.container,HomeFragment()).commit()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        //Bottom navigation functionalities
        //Changing the fragments in the admin page
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home -> supportFragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit()
                R.id.settings -> supportFragmentManager.beginTransaction().add(R.id.container, settingsFragment()).commit()
                R.id.info -> supportFragmentManager.beginTransaction().add(R.id.container, InfoFragment()).commit()
            }
            return@setOnItemSelectedListener true
        }
    }
}