package com.example.android.taazakhabar

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        health.setOnClickListener {

            val intent=Intent(this,Health_Activity::class.java)
            startActivity(intent)
        }
        Business.setOnClickListener{
            val bintent=Intent(this,Business_Activity::class.java)
            startActivity(bintent)
        }
        Sports.setOnClickListener {
            val sintent=Intent(this,Sports_Activity::class.java)
            startActivity(sintent)
        }
        Entertainment.setOnClickListener {
            val eintent=Intent(this,Entertainment_Activity::class.java)
            startActivity(eintent)
        }
        Science.setOnClickListener {
            val sintent=Intent(this,Science_Activity::class.java)
            startActivity(sintent)
        }
        Tech.setOnClickListener {
            val tintent=Intent(this,Tech_Activity::class.java)
            startActivity(tintent)
        }
    }

}