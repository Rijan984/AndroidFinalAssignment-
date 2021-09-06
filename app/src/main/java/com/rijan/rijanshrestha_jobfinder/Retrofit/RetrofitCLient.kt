package com.rijan.rijanshrestha_jobfinder.Retrofit

import com.google.gson.GsonBuilder
import com.rijan.rijanshrestha_jobfinder.Model.User
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitCLient {
    private const val BASE_URL="http://10.0.2.2:8000/"
    //    private const val BASE_URL="http://localhost:3000/"
    var token:String?= null
    var message:String?=null
    var data: User?=null
    //retrofit supported protocol
    private val okHttp = OkHttpClient.Builder()

    var gson= GsonBuilder().setLenient().create()
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())
    //Retrofit Instance
    private val retrofit= retrofitBuilder.build()
    //Generic function
    fun <T> buildService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }

}