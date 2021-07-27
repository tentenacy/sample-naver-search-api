package com.example.movieapi.di.module

import com.example.movieapi.data.repository.DefaultRepository
import com.example.movieapi.data.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideDefaultRepository(repo: MovieRepository): DefaultRepository
}