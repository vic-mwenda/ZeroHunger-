package com.example.splashjvm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener {
            startActivity(Intent(this,Dashboard::class.java))
            finish()
        }

        login_button.setOnClickListener {
            doLogin()
        }

    }
    fun doLogin(){
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
        auth.signInWithEmailAndPassword(tv_email.text.toString(), tv_password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        updateUI(null)
                    }
                }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser:FirebaseUser? = auth.currentUser
        updateUI(currentUser)
    }
    private  fun updateUI(currentUser : FirebaseUser?){
        if(currentUser != null){
            if(currentUser.isEmailVerified){
            startActivity(Intent(this,BaseActivity::class.java))
            finish()
        }else{
                Toast.makeText(baseContext, "Please verify your email",
                        Toast.LENGTH_SHORT).show()
            }

        } else{
            Toast.makeText(baseContext, "Login failed.",
                    Toast.LENGTH_SHORT).show()
        }
    }

    }


