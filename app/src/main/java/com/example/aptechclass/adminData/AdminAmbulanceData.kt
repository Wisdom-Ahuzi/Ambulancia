package com.example.aptechclass.adminData

import com.example.aptechclass.adminData.AdminAmbulanceData

data class AdminAmbulanceData (val ID: String,val Name: String, val Location: String, val Fees: String){
    companion object{
        val  defaultAmbulances = arrayListOf<AdminAmbulanceData>()
    }
}