package com.example.splashjvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_report_issue.*

class ReportIssue : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_issue)

        ////        create database
//        val db: SQLiteDatabase = openOrCreateDatabase("coronadb", Context.MODE_PRIVATE, null)
//
////        create a tables inside the database
//        db.execSQL("CREATE TABLE IF NOT EXISTS users(names VARCHAR, profession VARCHAR, residence VARCHAR, password VARCHAR )")

//        grab data from user after clicking save button
        btnsave.setOnClickListener {
            val name = etname.text.trim().toString()
            val contact = etcontact.text.trim().toString()
            val population = etpopulation.text.trim().toString()
            val location =etlocation.text.trim().toString()




        }

    }
}
