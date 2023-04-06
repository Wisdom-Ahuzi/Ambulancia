package com.example.aptechclass

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.adminAdapter.AdminAmbulanceAdapter
import com.example.aptechclass.adminData.AdminAmbulanceData
import com.example.aptechclass.sampleAdapter.AmbulanceAdapter
import com.example.aptechclass.sampleData.AmbulanceData

class Fragment_admin_home : Fragment() {

    private lateinit var adminambulanceList : ArrayList<AdminAmbulanceData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_home, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adminambulanceList = arrayListOf()
        adminambulanceList.addAll(AdminAmbulanceData.defaultAmbulances)

        val adminRecyclerView = view.findViewById<RecyclerView>(R.id.rvAdminContainer)

        adminRecyclerView?.layoutManager = LinearLayoutManager(context)


        val amAdminAdapter = AdminAmbulanceAdapter(adminambulanceList, parentFragmentManager)
        adminRecyclerView?.adapter = amAdminAdapter

        amAdminAdapter.notifyDataSetChanged()
    }
}