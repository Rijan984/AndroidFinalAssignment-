package com.rijan.rijanshrestha_jobfinder.Model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
    data class User (
    val _id : String? = null,
    val fname : String? = null,
    val lname : String? = null,
    val username : String? = null,
    val email : String? = null,
    val address : String? = null,
    val phone : String? = null,
    val role : String? = null,
    val password : String? = null

    ){
        @PrimaryKey(autoGenerate = true)
        var userId:Int=0
    }