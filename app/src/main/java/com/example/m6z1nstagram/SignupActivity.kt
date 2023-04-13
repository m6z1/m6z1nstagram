package com.example.m6z1nstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m6z1nstagram.databinding.ActivityLoginBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}