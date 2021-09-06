package com.rijan.rijanshrestha_jobfinder.Retrofit

import com.rijan.rijanshrestha_jobfinder.Model.User

data class UserResponse (
    val success:Boolean?=null,
    val accesstoken:String?=null,
    val message:String?=null,
    val token:String?=null,
    val data:ArrayList<User>?=null
)