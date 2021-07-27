package com.example.movieapi.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieapi.data.model.Movie

object BindingAdapters {

    @BindingAdapter("movieItemThumbnail")
    @JvmStatic
    fun setMovieItemThumbnail(imageView: ImageView, movie: Movie) {
        Glide.with(imageView.context)
            .load(movie.image)
            .into(imageView)
    }

    @BindingAdapter("movieItemTitle")
    @JvmStatic
    fun setMovieItemTitle(textView: TextView, movie: Movie) {
        textView.text = "${movie.title} (${movie.pubDate})"
    }
}