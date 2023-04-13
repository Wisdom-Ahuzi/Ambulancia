package com.example.aptechclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Admin_Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().add(R.id.adminContainer,Fragment_admin_home()).commit()

        val adminbottomNav = findViewById<BottomNavigationView>(R.id.adminBottomNav)

        //Bottom navigation functionalities
        //Changing the fragments in the home page
        adminbottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home -> supportFragmentManager.beginTransaction().add(R.id.adminContainer, Fragment_admin_home()).commit()
                R.id.add -> supportFragmentManager.beginTransaction().add(R.id.adminContainer, AddAmbulance()).commit()
                R.id.settings -> supportFragmentManager.beginTransaction().add(R.id.adminContainer, AdminSettings()).commit()
            }
            return@setOnItemSelectedListener true
        }
    }
}