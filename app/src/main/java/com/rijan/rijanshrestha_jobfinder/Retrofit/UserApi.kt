package com.rijan.rijanshrestha_jobfinder.Retrofit

import com.rijan.rijanshrestha_jobfinder.Model.Job
import com.rijan.rijanshrestha_jobfinder.Model.User
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    //Register User\
    @POST("/user/register")
    suspend fun registerUser(
        @Body user: User  //Sending the value attached to the body
    ):Response<LoginResponse> //Return some response from the api
    //Login user
//to pass the value in the url of the api
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun checkUser(
        @Field("username") username:String,
        @Field("password") password:String
    ):Response<LoginResponse>

    @POST("/job/register")
    suspend fun registerJob(
        @Body job: Job  //Sending the value attached to the body
    ):Response<LoginResponse> //Return some response from the api

    @GET("/user/display")
    suspend fun getUser(
    ): Response<UserResponse>

}