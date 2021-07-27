package com.example.movieapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movieapi.R
import com.example.movieapi.data.model.Movie
import com.example.movieapi.databinding.FragmentMovieListBinding
import com.example.movieapi.ui.adapter.MovieListAdapter
import com.example.movieapi.ui.listener.MovieItemClickListener
import com.example.movieapi.ui.viewmodel.MovieListViewModel
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : Fragment() {
    private val movieItemClickListener = object : MovieItemClickListener {
        override fun onClick(movie: Movie) {
            Navigation.findNavController(binding.root).navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieFragment(movie))
        }
    }

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MovieListViewModel>()

    @Inject
    lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMovieListSearch.setOnClickListener {
            val searchText = binding.editTextMovieListSearch.text.toString()
            if(searchText.trim().isNotBlank()) {
                viewModel.requestMovieList(searchText)
            }
        }


        viewModel.movieList.observe(viewLifecycleOwner) { movieList ->
            movieListAdapter.setMovieList(movieList)
        }

        movieListAdapter.setOnClickListener(movieItemClickListener)
        binding.recyclerViewMovieList.adapter = movieListAdapter
    }
}