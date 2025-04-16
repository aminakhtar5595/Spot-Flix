package com.example.spotflix.ui.model

data class SearchResponse(
    val results: List<Movie>
)

data class Movie(
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val poster_path: String?
)