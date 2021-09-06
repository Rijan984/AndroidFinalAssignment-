package com.rijan.rijanshrestha_jobfinder.Retrofit

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMyServie {
    @POST("register")
    @FormUrlEncoded
    fun registerUser(@Field("email") email:String,
                     @Field("name") name:String,
                     @Field("password") password:String)


    @POST("login")
    @FormUrlEncoded
    fun registerUser(@Field("email") email:String,
                     @Field("password") password:String)
}