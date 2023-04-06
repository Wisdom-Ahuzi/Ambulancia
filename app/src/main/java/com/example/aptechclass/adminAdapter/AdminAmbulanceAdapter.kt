package com.example.aptechclass.adminAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.AdminAmbulanceDetail
import com.example.aptechclass.R
import com.example.aptechclass.adminData.AdminAmbulanceData

class AdminAmbulanceAdapter (private val adminAmbulances:ArrayList<AdminAmbulanceData>, private val fragmentManager: FragmentManager) : RecyclerView.Adapter<AdminAmbulanceAdapter.AdminambulanceViewHolder>(){

    inner class AdminambulanceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameView: TextView = itemView.findViewById(R.id.adminName)
        val locationView: TextView = itemView.findViewById(R.id.adminLocation)
        val fees: TextView = itemView.findViewById(R.id.adminFees)
        val editButton: ImageView = itemView.findViewById(R.id.ivEditAmbulance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminambulanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.admin_ambulance_home, parent, false)
        return AdminambulanceViewHolder(view)    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdminambulanceViewHolder, position: Int) {
        holder.nameView.text = "Name: ${adminAmbulances[position].Name}"
        holder.locationView.text = "Location: ${adminAmbulances[position].Location}"
        holder.fees.text = "Fees: ${adminAmbulances[position].Fees.toString()}"

        holder.editButton.setOnClickListener {
            fragmentManager.beginTransaction().add(R.id.adminContainer,AdminAmbulanceDetail.newInstance("","")).commitNow()
        }
    }

    override fun getItemCount(): Int {
        return adminAmbulances.size

    }
}