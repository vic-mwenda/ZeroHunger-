package com.example.splashjvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.EventLogTags
import android.util.Log
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        login_icon.setOnClickListener {
            Log.d("Signup","Try signing up")
            val intent = Intent(this,Dashboard::class.java)
            startActivity(intent)
        }

        img_report.setOnClickListener{

        }

        }
}
