package com.example.aptechclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val AMBULANCE_ID = "ambulance_id"

/**
 * A simple [Fragment] subclass.
 * Use the [AdminAmbulanceDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdminAmbulanceDetail : Fragment() {
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
        return inflater.inflate(R.layout.fragment_admin_ambulance_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance();

//        id?.let { db.collection("cardAmbulance").document(it).delete() }

//       AlertDialog.Builder(view.context).setMessage("Are you sure you want to delete").show()

        //Fetching data from the firebase fire store and passing it into the admin details page.
        id.let {
            if (it != null) {
                db.collection("cardAmbulance").document(it).addSnapshotListener { value, error ->
                    value?.getString(
                        "Name"
                    )?.let { it1 ->
                        view.findViewById<TextInputEditText>(R.id.adminDetailName).setText(it1)
                    }

                    value?.getString(
                        "Fees"
                    )?.let { it1 ->
                        view.findViewById<TextInputEditText>(R.id.adminDetailFee).setText(it1)
                    }

                    value?.getString(
                        "Location"
                    )?.let { it1 ->
                        view.findViewById<TextInputEditText>(R.id.adminDetailLocation).setText(it1)
                    }

                    value?.getString(
                        "Description"
                    )?.let { it1 ->
                        view.findViewById<TextInputEditText>(R.id.adminDetailDescription).setText(it1)
                    }

                    value?.getString(
                        "Phone"
                    )?.let { it1 ->
                        view.findViewById<TextInputEditText>(R.id.adminDetailContact).setText(it1)
                    }
                }
            }
        }
        val adminDetailName = view.findViewById<TextInputEditText>(R.id.adminDetailName).text.toString()
        val adminDetailLocation = view.findViewById<TextInputEditText>(R.id.adminDetailLocation).text.toString()
        val adminDetailDescription = view.findViewById<TextInputEditText>(R.id.adminDetailDescription).text.toString()
        val adminDetailFee = view.findViewById<TextInputEditText>(R.id.adminDetailFee).text.toString()
        val adminDetailContact = view.findViewById<TextInputEditText>(R.id.adminDetailContact).text.toString()

        val updateAmbulance = view.findViewById<MaterialButton>(R.id.updateAmbulance)

        //Updating the ambulance company
        updateAmbulance.setOnClickListener {
            id?.let { db.collection("cardAmbulance").document(it).update("Name", adminDetailName)}
            parentFragmentManager.beginTransaction().add(R.id.container,Fragment_admin_home()).commit()
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(id: String) =
            AdminAmbulanceDetail().apply {
                arguments = Bundle().apply {
                    putString(AMBULANCE_ID, id)
                }
            }
    }
}