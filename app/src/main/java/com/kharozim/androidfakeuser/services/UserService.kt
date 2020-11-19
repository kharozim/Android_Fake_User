package com.kharozim.androidfakeuser.services

import com.kharozim.androidfakeuser.models.DataItem
import com.kharozim.androidfakeuser.models.UserModel
import com.kharozim.androidfakeuser.models.UserRequest
import com.kharozim.androidfakeuser.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("api/users")
    fun getAllUser(): Call<UserModel>

    @GET("api/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<DataItem>

    @POST("api/users")
    fun createUser(@Body req: UserRequest): Call<UserResponse>

    @DELETE("/api/users/{id}")
    fun getDeleteByID(@Path("id")id: Int) :Call<UserModel>

}