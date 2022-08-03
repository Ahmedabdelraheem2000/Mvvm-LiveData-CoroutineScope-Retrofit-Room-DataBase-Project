package com.shopping.livedata.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Posts_Instence {
    val api : Responce_Posts by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(Responce_Posts::class.java)
    }
}