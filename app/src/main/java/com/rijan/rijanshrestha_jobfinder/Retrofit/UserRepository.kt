package com.rijan.rijanshrestha_jobfinder.Retrofit

import com.rijan.rijanshrestha_jobfinder.Model.Job
import com.rijan.rijanshrestha_jobfinder.Model.User

class UserRepository():Request() {
    val myApi = RetrofitCLient.buildService(UserApi::class.java)
    suspend fun registerUser(user : User):LoginResponse{
        return apiRequest {
            myApi.registerUser(user)
        }
    }
    suspend fun registerJob(job : Job):LoginResponse{
        return apiRequest {
            myApi.registerJob(job)
        }
    }
    suspend fun checkUser(username:String,password:String):LoginResponse{
        return apiRequest {
            myApi.checkUser(username, password)
        }
    }
    suspend fun getUser():UserResponse{
        return apiRequest {
            myApi.getUser()
        }
    }

}