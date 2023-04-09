package com.example.aptechclass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance();

        val sign_up_btn = findViewById<Button>(R.id.signupbtn);

        sign_up_btn.setOnClickListener {
            val signupemail = findViewById<TextInputEditText>(R.id.signupemail).text.toString().trim()
            val signuppassword = findViewById<TextInputEditText>(R.id.signuppassword).text.toString()
            Log.i("emailv", signupemail)
            Log.i("passv", signuppassword)
            mAuth!!.signInWithEmailAndPassword(signupemail, signuppassword)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

//                            val user: FirebaseUser? = mAuth!!.currentUser


//                            val intent = Intent(applicationContext,Admin_Home::class.java)
//                            startActivity(intent)
                        Log.d("done", "onCreate: ")
                        Toast.makeText(
                            this, "Authentication Successful.", Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("TAG", "signInWithEmail:failure + ${task.exception.toString()}")
                        Toast.makeText(
                            this, "Authentication failed.", Toast.LENGTH_SHORT
                        ).show()

                    }

                    // ...
                })
        }
    }
}