package com.example.aptechclass.sampleAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.R
import com.example.aptechclass.sampleData.AmbulanceData

class AmbulanceAdapter (private val ambulances:ArrayList<AmbulanceData>) : RecyclerView.Adapter<AmbulanceAdapter.ambulanceViewHolder>(){

    inner class ambulanceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameView: TextView = itemView.findViewById(R.id.name)
        val locationView: TextView = itemView.findViewById(R.id.location)
        val fees: TextView = itemView.findViewById(R.id.fees)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ambulanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ambulance_home, parent, false)
        return ambulanceViewHolder(view)    }

    override fun onBindViewHolder(holder: ambulanceViewHolder, position: Int) {
        holder.nameView.text = "Name: ${ambulances[position].Name}"
        holder.locationView.text = "Location: ${ambulances[position].Location}"
        holder.fees.text = "Fees: ${ambulances[position].Fees.toString()}"
    }

    override fun getItemCount(): Int {
        return ambulances.size

    }
}