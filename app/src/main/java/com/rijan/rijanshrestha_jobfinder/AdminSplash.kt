package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class AdminSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_spalsh)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(Intent(this@AdminSplash, AdminActivity::class.java))
                finish()
            }, 2500
        )

    }
}