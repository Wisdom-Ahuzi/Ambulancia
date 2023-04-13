package com.example.aptechclass

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.aptechclass.sampleAdapter.AmbulanceAdapter
import com.example.aptechclass.sampleData.AmbulanceData
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {
    private lateinit var ambulanceList : ArrayList<AmbulanceData>
    private lateinit var amAdapter : AmbulanceAdapter
    private lateinit var swipeContainer: SwipeRefreshLayout

    private var db = Firebase.firestore
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ambulanceList = arrayListOf()
        ambulanceList.addAll(AmbulanceData.defaultAmbulances)

        swipeContainer =  view.findViewById<SwipeRefreshLayout>(R.id.swipeContainer)

        swipeContainer.setOnRefreshListener { // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.
            EventChangeListener()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvContainer)
        recyclerView.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(context)


        amAdapter = AmbulanceAdapter(ambulanceList, parentFragmentManager)

        recyclerView?.adapter = amAdapter


        EventChangeListener()

        val executeSearch = view.findViewById<ImageView>(R.id.executeSearch)


        executeSearch.setOnClickListener {
            val homeSearch = view.findViewById<EditText>(R.id.homeSearch).text.toString()

            val newList = ambulanceList.filter { it2 -> it2.Name == homeSearch }

            ambulanceList = newList as ArrayList<AmbulanceData>;

            amAdapter.notifyDataSetChanged()
        }
    }

    // Fetching data from the firebase fire store and passing them into each card of the recycler view of the home fragment page
    private fun EventChangeListener(){
        db = FirebaseFirestore.getInstance()
        db.collection("cardAmbulance").addSnapshotListener(object : EventListener<QuerySnapshot>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null){
                    Log.e("Firestore Error", error.message.toString())
                    return
                }
                ambulanceList.clear()
                for (ambulance in value?.documents!!) {
                    val name = ambulance.getString("Name")!!
                    val fees = ambulance.getString("Fees")!!
                    val location = ambulance.getString("Location")!!
                    ambulanceList.add(AmbulanceData(ambulance.id, name,location, fees))
                }

                amAdapter.notifyDataSetChanged()
                swipeContainer.isRefreshing = false
            }

        })
    }

}