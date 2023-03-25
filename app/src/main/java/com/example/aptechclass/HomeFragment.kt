package com.example.aptechclass

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechclass.sampleAdapter.AmbulanceAdapter
import com.example.aptechclass.sampleData.AmbulanceData

class HomeFragment : Fragment() {
    private lateinit var ambulanceList : ArrayList<AmbulanceData>
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ambulanceList = arrayListOf()
        ambulanceList.addAll(AmbulanceData.defaultAmbulances)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.rvContainer)

        recyclerView?.layoutManager = LinearLayoutManager(context)


        val amAdapter = AmbulanceAdapter(ambulanceList)
        recyclerView?.adapter = amAdapter

        amAdapter.notifyDataSetChanged()
    }

}