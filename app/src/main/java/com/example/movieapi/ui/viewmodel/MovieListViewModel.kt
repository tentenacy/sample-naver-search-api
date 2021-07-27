package com.example.movieapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.repository.DefaultRepository
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: DefaultRepository
): BaseViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList = _movieList

    init {
        Logger.d("MovieListViewModel initialized")
    }

    fun requestMovieList(searchText: String) {
        uiScope.launch {
            launch(Dispatchers.IO) {
                repository.getMovieList(searchText)?.let { response ->
                    if(response.isSuccessful) {
                        response.body()?.let { result ->
                            Logger.d(result)
                            _movieList.postValue(result.items)
                        }
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}