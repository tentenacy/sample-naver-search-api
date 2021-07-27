package com.example.movieapi.util

import com.example.movieapi.data.dao.NaverSearchApi
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val naverSearchApi: NaverSearchApi

    init {
        val baseUrl = "https://openapi.naver.com/"

        val client = OkHttpClient.Builder()

        val baseInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()

            Logger.d(originalRequest.headers())

            val response = chain.proceed(originalRequest)

            Logger.d("${response.headers()} ${response.message()}")

            response
        }

        client.addInterceptor(baseInterceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        naverSearchApi = retrofit.create(NaverSearchApi::class.java)
    }
}