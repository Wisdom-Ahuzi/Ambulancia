package com.example.aptechclass

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import kotlin.system.exitProcess

class settingsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exitApp = view.findViewById<TextView>(R.id.exitApp)

        // Functionality for exiting the app
        exitApp?.setOnClickListener{
            exitProcess(0)
        }

        val login = view.findViewById<TextView>(R.id.login)

        //Functionality for the sign out button
        login.setOnClickListener {
            val intent = Intent(context?.applicationContext,Login::class.java)
            startActivity(intent)
        }

        // Functionality for enabling/disabling dark mode
        val switchOne = view.findViewById<Switch>(R.id.switchOne)
        
        switchOne.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }
        
    }
}