package com.example.aptechclass.sampleData

data class AmbulanceData (val Name: String, val Location: String, val Fees: Int)
{
    companion object{
        val  defaultAmbulances = arrayListOf<AmbulanceData>()
    }
}