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

    @BindingAdapter("movieThumbnail")
    @JvmStatic
    fun setMovieThumbnail(imageView: ImageView, movie: Movie) {
        Glide.with(imageView.context)
            .load(movie.image)
            .into(imageView)
    }

    @BindingAdapter("movieAll")
    @JvmStatic
    fun setMovieAll(textView: TextView, movie: Movie) {
        val directorConverted = movie.director.replace("|", ", ").trimEnd(' ', ',')
        val actorConverted = movie.actor.replace("|", ", ").trimEnd(' ', ',')
        textView.text = "제목: ${movie.title}\n" +
                "출시년도: ${movie.pubDate}\n" +
                "감독: ${directorConverted}\n" +
                "배우: ${actorConverted}\n" +
                "평점: ${movie.userRating}"
    }
}