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

    private val _favoriteMovies = mutableListOf<Movie>()
    val favoriteMovies: List<Movie> = _favoriteMovies

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun search(query: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = RetrofitInstance.api.searchMovies(query, "0e5100f04570b619d0437918f0a2cc40")
                _movies.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
                _movies.value = emptyList()
            } finally {
                _loading.value = false
            }
        }
    }

    fun toggleFavorite(movie: Movie) {
        if (_favoriteMovies.any { it.id == movie.id }) {
            _favoriteMovies.removeAll { it.id == movie.id }
        } else {
            _favoriteMovies.add(movie)
        }
    }

    fun isFavorite(movie: Movie): Boolean {
        return _favoriteMovies.any { it.id == movie.id }
    }
}