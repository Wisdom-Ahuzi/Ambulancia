package com.example.aptechclass.adminData

import com.example.aptechclass.adminData.AdminAmbulanceData

data class AdminAmbulanceData (val Name: String, val Location: String, val Fees: Int){
    companion object{
        val  defaultAmbulances = arrayListOf<AdminAmbulanceData>()
    }
}