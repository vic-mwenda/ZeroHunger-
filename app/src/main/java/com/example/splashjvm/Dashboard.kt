package com.example.splashjvm

import android.content.Intent
import android.os.Bundle
import android.util.EventLogTags
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.util.regex.Pattern

class Dashboard : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        auth = FirebaseAuth.getInstance()

        btnAlert.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }

        btn_register.setOnClickListener {
            signupUser()
        }

    }
    fun signupUser(){
        if(tv_email.text.toString().isEmpty()){
            tv_email.error = "Please enter email"
            tv_email.requestFocus()
            return
        }
        if(tv_password.text.toString().isEmpty()){
            tv_password.error = "Please enter password"
            tv_password.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(tv_email.text.toString(), tv_password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user:FirebaseUser? = auth.currentUser
                        user?.sendEmailVerification()
                                ?.addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        startActivity(Intent(this,BaseActivity::class.java))
                                        finish()
                                    }
                                }

                    } else {
                        Toast.makeText(baseContext, "SignUp failed.Try again later",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }

}
