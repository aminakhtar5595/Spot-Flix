package com.example.spotflix.ui.screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spotflix.ui.components.Header
import com.example.spotflix.ui.viewmodel.MovieDetailViewModel

@Composable
fun DetailsScreen(movieId: Int, navController: NavController, viewModel: MovieDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val movie by viewModel.movieDetail.collectAsState()
    val isLoading by viewModel.loading.collectAsState()
    
    LaunchedEffect(movieId) {
        viewModel.fetchMovieDetail(movieId)
    }
    
    Column {
        // Header
        Header(title = "Movie Info", navController = { navController.popBackStack() })

        if (isLoading) {
            // Loader
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            // Show movie detail
            movie?.let {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500${it.poster_path}",
                        contentDescription = "Poster of ${it.title}",
                        modifier = Modifier.size(150.dp)
                    )

                    Text(
                        it.title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(vertical = 5.dp)
                    )

                    Text(
                        it.vote_average,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Red
                        )
                    )

                    Text(
                        it.release_date,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Red
                        ),
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                ) {
                    Text(text = "Overview",
                        style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ), modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = it.overview,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W400))
                }
            }?: Text("Failed to load movie details.")
        }
    }
}