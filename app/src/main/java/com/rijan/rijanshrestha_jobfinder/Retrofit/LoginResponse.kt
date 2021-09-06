package com.rijan.rijanshrestha_jobfinder.Retrofit

import com.rijan.rijanshrestha_jobfinder.Model.User
data class LoginResponse(
    //Get response of the api to know the data updated or created or something more
    val success:Boolean?=null,
    val token:String?=null,
val data:ArrayList<User>?=null
)