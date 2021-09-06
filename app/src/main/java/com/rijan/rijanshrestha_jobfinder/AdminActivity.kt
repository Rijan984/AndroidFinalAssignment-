package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        btnAddJobs.setOnClickListener {
            startActivity(Intent(this@AdminActivity, AddJob::class.java))
        }

        btndetails.setOnClickListener {
            startActivity(Intent(this@AdminActivity, UserDetails::class.java))
        }
    }
}