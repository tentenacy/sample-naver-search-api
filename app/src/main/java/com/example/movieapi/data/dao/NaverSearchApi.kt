package com.example.movieapi.data.dao

import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.model.ResultSearchMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverSearchApi {
    @GET("v1/search/movie.json")
    fun getMovieList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") searchText: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
    ): Call<ResultSearchMovie?>
}