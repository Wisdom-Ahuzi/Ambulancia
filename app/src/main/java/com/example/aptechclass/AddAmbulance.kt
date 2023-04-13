package com.example.aptechclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddAmbulance.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAmbulance : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_ambulance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createAmbulance = view.findViewById<MaterialButton>(R.id.createAmbulance)

        val db = FirebaseFirestore.getInstance()

        createAmbulance.setOnClickListener {
            val addName = view.findViewById<TextInputEditText>(R.id.addName).text.toString()
            val addLocation = view.findViewById<TextInputEditText>(R.id.addLocation).text.toString()
            val addDescription = view.findViewById<TextInputEditText>(R.id.addDescription).text.toString()
            val addFees = view.findViewById<TextInputEditText>(R.id.addFees).text.toString()
            val addNumber = view.findViewById<TextInputEditText>(R.id.addNumber).text.toString()
            if (addName.isNotEmpty() && addLocation.isNotEmpty() && addDescription.isNotEmpty() && addFees.isNotEmpty() && addNumber.isNotEmpty()){
                db.collection("cardAmbulance").add(hashMapOf("Name" to addName, "Location" to addLocation, "Fees" to addFees, "Description" to addDescription, "Phone" to addNumber, "DateAdded" to FieldValue.serverTimestamp())).addOnSuccessListener {
                    Toast.makeText(view.context, "Added", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.popBackStack()
                }.addOnFailureListener {
                    Toast.makeText(view.context, "Failed, So Sad", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(view.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddAmbulance().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}