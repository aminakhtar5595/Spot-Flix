package com.example.spotflix.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotflix.ui.api.RetrofitInstance
import com.example.spotflix.ui.model.MovieDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {
    private val _movieDetail = MutableStateFlow<MovieDetail?>(null)
    val movieDetail: StateFlow<MovieDetail?> = _movieDetail

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = RetrofitInstance.api.movieDetails(movieId, "0e5100f04570b619d0437918f0a2cc40")
                _movieDetail.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }
}