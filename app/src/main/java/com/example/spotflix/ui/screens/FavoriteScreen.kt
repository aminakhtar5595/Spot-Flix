package com.example.spotflix.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spotflix.ui.viewmodel.SearchViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.spotflix.ui.components.Header
import com.example.spotflix.ui.components.MovieCard

@Composable
fun FavoriteScreen(navController: NavController, viewModel: SearchViewModel) {
    val favorites by viewModel.favoriteMovies.collectAsState()

    Column {
        // Header
        Header(title = "Your Favorites", navController = { navController.popBackStack() })

        // Favorite movies list
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(favorites) { movie ->
                MovieCard(
                    movie = movie,
//                    isFavorite = true,
                    isFavorite = viewModel.isFavorite(movie),
                    onFavoriteClick = { viewModel.toggleFavorite(movie) },
                    onClick = { navController.navigate("detailsScreen/${movie.id}") }
                )
            }
        }
    }
}