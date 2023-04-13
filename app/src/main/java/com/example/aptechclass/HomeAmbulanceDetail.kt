package com.example.aptechclass

import android.app.AlertDialog
import android.content.Intent
import android.media.metrics.Event
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.*

private const val AMBULANCE_ID = "ambulance_id"

class HomeAmbulanceDetail : Fragment() {
    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(AMBULANCE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_ambulance_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance();

        val phone = view.findViewById<MaterialButton>(R.id.phone)

        //Fetching data from the firebase fire store and passing them to the detail's page
        id?.let { db.collection("cardAmbulance").document(it).addSnapshotListener { value, error ->
            value?.getString(
                "Name"
            )?.let { it1 ->
                view.findViewById<TextView>(R.id.tvDetailName).text = it1
            }

            value?.getString(
                "Fees"
            )?.let { it1 ->
                view.findViewById<TextView>(R.id.tvDetailFee).text = it1
            }

            value?.getString(
                "Location"
            )?.let { it1 ->
                view.findViewById<TextView>(R.id.tvDetailLocation).text = it1
            }

            value?.getString(
                "Description"
            )?.let { it1 ->
                view.findViewById<TextView>(R.id.tvDetailDescription).text = it1
            }
            value?.getString(
                "Phone"
            )?.let { it1 ->
                phone.text = it1
            }
        }
        }

        //Makes a phone call to the ambulance service.
        phone.setOnClickListener {
            val callIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse(phone.text.toString()))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(id: String) =
            HomeAmbulanceDetail().apply {
                arguments = Bundle().apply {
                    putString(AMBULANCE_ID, id)
                }
            }
    }
}