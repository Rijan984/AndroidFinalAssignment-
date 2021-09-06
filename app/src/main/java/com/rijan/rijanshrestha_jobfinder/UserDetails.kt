package com.rijan.rijanshrestha_jobfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rijan.rijanshrestha_jobfinder.Model.User
import com.rijan.rijanshrestha_jobfinder.Retrofit.RetrofitCLient
import com.rijan.rijanshrestha_jobfinder.Retrofit.UserRepository
import com.rijan.rijanshrestha_jobfinder.user.PostAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class UserDetails : AppCompatActivity() {
    private lateinit var recycle: RecyclerView
    private lateinit var user:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        recycle = findViewById(R.id.recyclerView2)

        getvalues()
        recycle.adapter?.notifyDataSetChanged()
    }

    fun getvalues() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val repository=UserRepository()
                val response=repository.getUser()
                if(response.success==true) {
                    withContext(Dispatchers.Main) {
                        val post= response.data
                        val adapter = PostAdapter(post!!, this@UserDetails)
                        recycle.layoutManager = LinearLayoutManager(this@UserDetails)
                        recycle.adapter = adapter
                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@UserDetails, "data is empty", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        } catch (e: IOException) {
            Toast.makeText(this, "Error ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }

    }
}