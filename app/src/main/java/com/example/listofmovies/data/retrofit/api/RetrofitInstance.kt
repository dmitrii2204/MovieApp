package com.example.listofmovies.data.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(DataBaseAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    val api: DataBaseAPI by lazy {
        retrofit.create(DataBaseAPI::class.java)
    }
}