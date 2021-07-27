package com.example.movieapi.di.module

import com.example.movieapi.ui.adapter.MovieListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideMovieListAdapter(): MovieListAdapter {
        return MovieListAdapter()
    }
}