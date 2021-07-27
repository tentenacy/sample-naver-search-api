package com.example.movieapi.data.repository

import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.model.ResultSearchMovie
import retrofit2.Response

interface DefaultRepository {
    fun getMovieList(searchText: String): Response<ResultSearchMovie?>
}