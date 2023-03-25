package com.example.aptechclass.sampleData

data class AmbulanceData (val Name: String, val Location: String, val Fees: Int){
    companion object{
        val  defaultAmbulances = arrayListOf(
            AmbulanceData("St John's ","Riga, Latvia", 5000),
            AmbulanceData("Eko Hospital", "Ikeja, Lagos", 4000),
            AmbulanceData("Treasure Hospital", "Iba, Lagos", 3000),
            AmbulanceData("Mother and Child", "Festac, Lagos", 7000),
            AmbulanceData("Usman Danfodio", "Gwagwalada, Abuja", 1000)
        )
    }
}