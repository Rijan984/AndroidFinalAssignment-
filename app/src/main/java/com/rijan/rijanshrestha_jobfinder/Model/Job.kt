package com.rijan.rijanshrestha_jobfinder.Model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Job(
        @PrimaryKey
        var id:String="",
        val jobs : String? = null,
        val location : String? = null,
        val experience : String? = null,
        val description : String? = null,
        val position : String? = null
)

