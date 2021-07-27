package com.example.movieapi.data.repository

import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.model.ResultSearchMovie
import com.example.movieapi.util.Constants
import com.example.movieapi.util.RetrofitBuilder
import com.orhanobut.logger.Logger
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(): DefaultRepository {
    init {
        Logger.d("MovieRepository instantiated")
    }
    override fun getMovieList(searchText: String): Response<ResultSearchMovie?> {
        return RetrofitBuilder.naverSearchApi.getMovieList(
            Constants.naverSearchClientId,
            Constants.naverSearchClientSecret,
            searchText
        ).execute()
    }
}