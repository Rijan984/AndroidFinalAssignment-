package com.rijan.rijanshrestha_jobfinder.Retrofit


import com.rijan.rijanshrestha_jobfinder.Model.Job


data class JobResponse(
    val success:Boolean?=null,
    val data:ArrayList<Job>?=null,
    val message:String?=null
)