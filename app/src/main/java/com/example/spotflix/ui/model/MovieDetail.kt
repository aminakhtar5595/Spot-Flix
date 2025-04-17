package com.example.spotflix.ui.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)