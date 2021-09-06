package com.rijan.rijanshrestha_jobfinder.Retrofit


import com.rijan.rijanshrestha_jobfinder.Model.Job
import com.rijan.rijanshrestha_jobfinder.Model.User
import com.rijan.rijanshrestha_jobfinder.Retrofit.JobResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface JobApi {

    //Register User\
    @POST("auth/register")
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

    @POST("auth/job")
    suspend fun medicineDonation(
        @Body job: Job  //Sending the value attached to the body
    ):Response<JobResponse> //Return some response from the api
}