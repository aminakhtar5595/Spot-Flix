package com.example.spotflix.ui.model

data class SearchResponse(
    val results: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val vote_average: String,
    val release_date: String,
    val poster_path: String
)