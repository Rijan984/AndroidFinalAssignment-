package com.rijan.rijanshrestha_jobfinder.Retrofit

import androidx.room.Entity

@Entity
data class JobRequest (
    val jobs : String? = null,
    val location : String? = null,
    val experience : String? = null
)