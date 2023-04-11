package com.example.aptechclass

import android.app.AlertDialog
import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.firestore.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val AMBULANCE_ID = "ambulance_id"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeAmbulanceDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_ambulance_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance();

//        db.collection("cardAmbulance").document("")

//       AlertDialog.Builder(view.context).setMessage("Are you sure you want to delete").show()

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

        }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         */
        @JvmStatic
        fun newInstance(id: String) =
            HomeAmbulanceDetail().apply {
                arguments = Bundle().apply {
                    putString(AMBULANCE_ID, id)
                }
            }
    }
}