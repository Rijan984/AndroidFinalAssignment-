package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.rijan.rijanshrestha_jobfinder.Model.User
import com.rijan.rijanshrestha_jobfinder.Retrofit.RetrofitCLient
import com.rijan.rijanshrestha_jobfinder.Retrofit.UserRepository
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        register_login.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
        img_back.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
        btn_register.setOnClickListener(){
            //register()
            validateRegisterDetails()

        }
    }

    private fun validateRegisterDetails():Boolean {



        if (et_fname.text.toString().isEmpty()) {
            et_fname.error="Fill all the information"
            return false
        }
        else if (et_lname.text.toString().isEmpty()) {
            et_lname.error="Fill all the information"
            return false
        } else if(et_Email.text.toString().isEmpty()) {
            et_Email.error="Fill all the information"
            return false
        }
        else if(et_Username.text.toString().isEmpty()){
            et_Username.error="Fill alll the information"
            return false
        }
        else if(et_Phone.text.toString().isEmpty()){
            et_Phone.error="Fill alll the information"
            return false
        }
        else if(et_Address.text.toString().isEmpty()){
            et_Address.error="Fill alll the information"
            return false
        }
        else if(et_Password.text.toString().isEmpty()){
            et_Password.error="Fill alll the information"
            return false
        }
        else if(et_Password.text.toString().length<=5){
            et_Password.error="Password must be greater than five characters"
        }

        else{

//            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this@RegisterActivity, RegisterActivity::class.java))
            register()
        }
        return true
    }

    private fun register(){
        val firstName = et_fname.text.toString()
        val lastName = et_lname.text.toString()
        val email = et_Email.text.toString()
        val address = et_Address.text.toString()
        val phone = et_Phone.text.toString()
        val username = et_Username.text.toString()
        val password = et_Password.text.toString()
//        val confirmPassword = et_ConfirmPassword.text.toString()
            val user =
                User(fname = firstName, lname = lastName, username = username, email = email, address = address, phone = phone, password = password)
            CoroutineScope(Dispatchers.IO).launch {
                try{
                val repository = UserRepository()
                val response = repository.registerUser(user)
                if(response.success == true){
                    RetrofitCLient.token = response.token
                        Toast.makeText(this@RegisterActivity, "You are successfully Registered", Toast.LENGTH_SHORT).show()

                    finish()
                }else{
                    withContext(Main){
                        Toast.makeText(this@RegisterActivity, "fail", Toast.LENGTH_SHORT).show()
                        //startActivity(Intent(this@RegisterActivity, RegisterActivity::class.java))
                    }
                }}catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Success", Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this@RegisterActivity, RegisterActivity::class.java))
                    }
                }
            }
            // Api code goes here
    }
}
