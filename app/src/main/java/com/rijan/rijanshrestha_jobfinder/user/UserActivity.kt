package com.rijan.rijanshrestha_jobfinder.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rijan.rijanshrestha_jobfinder.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        btnsetting.setOnClickListener{
            startActivity(Intent(this@UserActivity, UserProfile::class.java))

        }
    }
}