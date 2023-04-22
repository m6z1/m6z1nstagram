package com.example.m6z1nstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m6z1nstagram.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    private lateinit var binding : ActivityLoginBinding//뷰 바인딩
    var googleSignInClient: GoogleSignInClient? = null
    var GOOGLE_LOGIN_CODE = 7354
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()
        binding.SignupEmail.setOnClickListener {
            signupbyEmail()
        }
        binding.SigninEmail.setOnClickListener {
            signinbyEmail()
        }
        binding.GoogleLogin.setOnClickListener {
            googleLogin()
        }
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("867648276666-adv2d30biskk0s20s4rj3fqhlru6a89d.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,gso)
    }

    private fun googleLogin() {
        var signInIntent = googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, GOOGLE_LOGIN_CODE)
    }

    private fun startActivityForResult(signInIntent: Intent?, googleLoginCode: Int) {
        TODO("Not yet implemented")
    }

    fun signinbyEmail() {
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

    fun signupbyEmail() {
        startActivity(
            Intent (this, SignupActivity::class.java)
        )
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
