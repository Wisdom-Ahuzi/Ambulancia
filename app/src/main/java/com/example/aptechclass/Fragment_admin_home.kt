package com.example.aptechclass

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.adminAdapter.AdminAmbulanceAdapter
import com.example.aptechclass.adminData.AdminAmbulanceData
import com.example.aptechclass.sampleAdapter.AmbulanceAdapter
import com.example.aptechclass.sampleData.AmbulanceData
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Fragment_admin_home : Fragment() {

    private lateinit var adminambulanceList : ArrayList<AdminAmbulanceData>
    private lateinit var amAdminAdapter : AdminAmbulanceAdapter
    var db = Firebase.firestore

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
        adminRecyclerView.setHasFixedSize(true)

        adminRecyclerView?.layoutManager = LinearLayoutManager(context)


        amAdminAdapter = AdminAmbulanceAdapter(adminambulanceList, parentFragmentManager)
        adminRecyclerView?.adapter = amAdminAdapter


        EventChangeListener()
    }

    // Fetching data from the firebase fire store and passing them into each card of the recycler view of the admin page
    private fun EventChangeListener(){
        db = FirebaseFirestore.getInstance()
        db.collection("cardAmbulance").addSnapshotListener(object : EventListener<QuerySnapshot>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null){
                    Log.e("Firestore Error", error.message.toString())
                    return
                }
                for (ambulance in value?.documents!!) {
                    val name = ambulance.getString("Name")!!
                    val fees = ambulance.getString("Fees")!!
                    val location = ambulance.getString("Location")!!
                    adminambulanceList.add(AdminAmbulanceData(ambulance.id,name,location, fees))
                }

                amAdminAdapter.notifyDataSetChanged()
            }

        })
    }
}