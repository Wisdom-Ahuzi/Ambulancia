package com.example.aptechclass.adminData

import com.example.aptechclass.adminData.AdminAmbulanceData

data class AdminAmbulanceData (val Name: String, val Location: String, val Fees: Int){
    companion object{
        val  defaultAmbulances = arrayListOf(
            AdminAmbulanceData("St Peter's ","Athens, Greece", 9000),
            AdminAmbulanceData("New York Hospital", "Boston, NY", 10000),
            AdminAmbulanceData("Vhegar Hospital", "Dragonstone, Westoros", 13000),
            AdminAmbulanceData("Viserys the peaceful Hospital", "Kingslanding, Westoros", 17000),
            AdminAmbulanceData("Lena Driftmark Hospital", "Driftmark, Braavos", 800)
        )
    }
}