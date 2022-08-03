package com.shopping.livedata.server

import com.shopping.livedata.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface Responce_Posts {

    @GET("/posts")
    fun getPostFrom_API():Call<Posts> //Get Data From Api
}