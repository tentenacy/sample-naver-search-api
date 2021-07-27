package com.example.movieapi.ui.listener

import com.example.movieapi.data.model.Movie

interface MovieItemClickListener {
    fun onClick(movie: Movie)
}