package com.rijan.rijanshrestha_jobfinder.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rijan.rijanshrestha_jobfinder.R
import com.rijan.rijanshrestha_jobfinder.user.EditActivity
import kotlinx.android.synthetic.main.activity_user_profile2.*

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile2)


        btnedit.setOnClickListener{
            startActivity(Intent(this@UserProfile, EditActivity::class.java))
        }
    }
}