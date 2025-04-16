package com.example.spotflix.ui.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
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

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _favoriteMovies = MutableStateFlow<List<Movie>>(emptyList())
    val favoriteMovies: StateFlow<List<Movie>> = _favoriteMovies


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
        val currentList = _favoriteMovies.value.toMutableList()
        if (currentList.any { it.id == movie.id }) {
            currentList.removeAll { it.id == movie.id }
            Log.d("FAV", "Removed ${movie.title}")
        } else {
            currentList.add(movie)
            Log.d("FAV", "Added ${movie.title}")
        }
        _favoriteMovies.value = currentList
    }

    fun isFavorite(movie: Movie): Boolean {
        return _favoriteMovies.value.any { it.id == movie.id }
    }

}