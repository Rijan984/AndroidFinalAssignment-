package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rijan.rijanshrestha_jobfinder.Model.Job
import com.rijan.rijanshrestha_jobfinder.Retrofit.RetrofitCLient
import com.rijan.rijanshrestha_jobfinder.Retrofit.UserRepository
import kotlinx.android.synthetic.main.activity_add_job.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddJob : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_job)

        btnadd.setOnClickListener {
            validateJobDetails()
        }
    }

    private fun validateJobDetails():Boolean {



        if (etjob.text.toString().isEmpty()) {
            etjob.error="Fill all the information"
            return false
        }
        else if (etlocation.text.toString().isEmpty()) {
            etlocation.error="Fill all the information"
            return false
        } else if(etexp.text.toString().isEmpty()) {
            etexp.error="Fill all the information"
            return false
        }
        else if(etdescription.text.toString().isEmpty()){
            etdescription.error="Fill alll the information"
            return false
        }
        else if(etposition.text.toString().isEmpty()){
            etposition.error="Fill alll the information"
            return false
        }

        else{

//            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this@RegisterActivity, RegisterActivity::class.java))
            addjob()
        }
        return true
    }




    private fun addjob(){
        val jobs = etjob.text.toString()
        val location = etlocation.text.toString()
        val experience = etexp.text.toString()
        val description= etdescription.text.toString()
        val position = etposition.text.toString()
//        val username = et_Username.text.toString()
//        val password = et_Password.text.toString()
//        val confirmPassword = et_ConfirmPassword.text.toString()
        val job =
            Job(jobs = jobs, location = location, experience = experience, description = description, position = position)
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val repository = UserRepository()
                val response = repository.registerJob(job)
                if(response.success == true){
                    RetrofitCLient.token = response.token

                    Toast.makeText(this@AddJob, "Success", Toast.LENGTH_SHORT).show()


                }
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@AddJob, "Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@AddJob, AddJob::class.java))
                        finish()
                    }
                }catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@AddJob,
                        "Error", Toast.LENGTH_SHORT

                    ).show()


                }
            }
        }
        // Api code goes here
    }
}