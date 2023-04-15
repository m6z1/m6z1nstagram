package com.example.m6z1nstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m6z1nstagram.databinding.ActivityLoginBinding
import com.example.m6z1nstagram.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignupActivity : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()
        binding.finishSignup.setOnClickListener {
            signupbyEmail()
        }
    }

    private fun signupbyEmail() {
        if (binding.PutPasswd == binding.CheckPasswd) {
            auth?.createUserWithEmailAndPassword(
                binding.PutEmail.text.toString(),
                binding.PutPasswd.text.toString()
            )
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        moveLoginPage()
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }
        }

    }

    private fun moveLoginPage() {
        startActivity(Intent(this, LoginActivity::class.java))
    }


}