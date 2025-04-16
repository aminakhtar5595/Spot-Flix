package com.example.spotflix.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotflix.ui.api.RetrofitInstance
import com.example.spotflix.ui.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun search(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchMovies(query, "0e5100f04570b619d0437918f0a2cc40")
                _movies.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
                _movies.value = emptyList()
            }
        }
    }
}