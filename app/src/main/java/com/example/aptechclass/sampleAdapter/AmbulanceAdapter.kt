package com.example.aptechclass.sampleAdapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.HomeAmbulanceDetail
import com.example.aptechclass.R
import com.example.aptechclass.sampleAdapter.AmbulanceAdapter
import com.example.aptechclass.sampleData.AmbulanceData

class AmbulanceAdapter (private val ambulances:ArrayList<AmbulanceData>, private val fragmentManager: FragmentManager) : RecyclerView.Adapter<AmbulanceAdapter.AmbulanceViewHolder>(){

    inner class AmbulanceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameView: TextView = itemView.findViewById(R.id.name)
        val locationView: TextView = itemView.findViewById(R.id.location)
        val fees: TextView = itemView.findViewById(R.id.fees)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbulanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ambulance_home, parent, false)
        return AmbulanceViewHolder(view)    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AmbulanceViewHolder, position: Int) {
        holder.nameView.text = "Name: ${ambulances[position].Name}"
        holder.locationView.text = "Location: ${ambulances[position].Location}"
        holder.fees.text = "Fees: ${ambulances[position].Fees}"

        holder.itemView.setOnClickListener {
            fragmentManager.beginTransaction().add(R.id.container, HomeAmbulanceDetail.newInstance(ambulances[position].ID)).commitNow()
        }
    }

    override fun getItemCount(): Int {
        return ambulances.size

    }
}