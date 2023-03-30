package com.example.m6z1nstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m6z1nstagram.databinding.ActivityLoginBinding
import com.example.m6z1nstagram.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    private val binding = ActivityLoginBinding.inflate(layoutInflater);
    override fun setContentView(layoutResID: Int) {
        (binding.root)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
    }

}
