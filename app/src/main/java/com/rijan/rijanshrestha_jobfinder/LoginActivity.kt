package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.rijan.rijanshrestha_jobfinder.Retrofit.IMyServie
import com.rijan.rijanshrestha_jobfinder.Retrofit.RetrofitCLient
import com.rijan.rijanshrestha_jobfinder.Retrofit.UserRepository
import com.rijan.rijanshrestha_jobfinder.user.UserActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_Email
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    lateinit var iMyServie: IMyServie


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
        tv_register.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        btn_login.setOnClickListener{
            validateAdmin()

        }

    }

    private fun validateAdmin():Boolean{

        if(et_Email.text.toString().isEmpty())
        {
            et_Email.error="Please enter email"
        }
        else if(et_ConfirmPassword.text.toString().isEmpty()){
            et_Password.error="Please enter password"
        }
        else if(et_Email.text.toString()=="admin" && et_ConfirmPassword.text.toString()=="admin"){
            startActivity(Intent(this@LoginActivity, AdminSplash::class.java))
        }
        else{
            login()
        }
        return false
    }

    private fun login() {
        val username = et_Email.text.toString()
        val password = et_ConfirmPassword.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    RetrofitCLient.token = "Bearer " + response.token
                    startActivity(
                        Intent(
                            this@LoginActivity,
                            UserActivity::class.java
                        )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginActivity,

                        "Login error", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}