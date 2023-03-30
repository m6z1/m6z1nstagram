package com.example.m6z1nstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m6z1nstagram.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    private val binding = ActivityLoginBinding.inflate(layoutInflater)
    override fun setContentView(layoutResID: Int) {
        (binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        binding.SignupEmail.setOnClickListener {
            signinAndSignup()
        }
    }

    fun signinAndSignup() {
        auth?.createUserWithEmailAndPassword(
            binding.PutEmail.text.toString(),
            binding.PutPasswd.text.toString()
        )
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    moveMainPage(task.result.user)
                } else if (task.exception?.message.isNullOrEmpty()) {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                } else {
                    signinEmail()
                }
            }
    }

    fun signinEmail() {
        auth?.createUserWithEmailAndPassword(
            binding.PutEmail.text.toString(),
            binding.PutPasswd.text.toString()
        )
            ?.addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    moveMainPage(task.result.user)
                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    fun moveMainPage(user: FirebaseUser?) {
        if (user != null) {
            startActivity(
                Intent
                    (this, MainActivity::class.java)
            )
        }
    }
}
