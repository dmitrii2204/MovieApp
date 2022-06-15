package com.example.listofmovies.data.retrofit.api

import com.example.listofmovies.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface DataBaseAPI {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("https://api.themoviedb.org/3/movie/popular?api_key=f026792d5170f665c600817536f77d5e&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>
}