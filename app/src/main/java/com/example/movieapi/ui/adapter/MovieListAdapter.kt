package com.example.movieapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.data.model.Movie
import com.example.movieapi.databinding.ItemMovieBinding
import com.example.movieapi.ui.listener.MovieItemClickListener
import com.example.movieapi.util.MovieDiffCallback
import javax.inject.Inject

class MovieListAdapter
    : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    private var movieList = emptyList<Movie>()
    private lateinit var movieItemClickListener: MovieItemClickListener

    inner class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.constraintLayoutItemMovieRoot.setOnClickListener {
                binding.movie?.let { movie ->
                    movieItemClickListener.onClick(movie)
                }
            }
        }

        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {
        return ViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun setMovieList(movieList: List<Movie>) {
        val diffResult = DiffUtil.calculateDiff(MovieDiffCallback(this.movieList, movieList), false)
        diffResult.dispatchUpdatesTo(this)
        this.movieList = movieList
    }

    fun setOnClickListener(movieItemClickListener: MovieItemClickListener) {
        this.movieItemClickListener = movieItemClickListener
    }
}