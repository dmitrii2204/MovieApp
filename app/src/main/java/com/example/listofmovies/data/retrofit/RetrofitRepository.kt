package com.example.listofmovies.data.retrofit

import com.example.listofmovies.data.retrofit.api.RetrofitInstance
import com.example.listofmovies.model.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovie()
    }
}