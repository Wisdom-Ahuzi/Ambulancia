package com.example.aptechclass

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.system.exitProcess

class settingsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        val exitApp = view?.findViewById<TextView>(R.id.exitApp)

        exitApp?.setOnClickListener{
            exitProcess(0)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<TextView>(R.id.login)

        login.setOnClickListener {
            val intent = Intent(context?.applicationContext,Login::class.java)
            startActivity(intent)
        }
    }
}