package com.example.spotflix.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spotflix.ui.viewmodel.MovieDetailViewModel

@Composable
fun DetailsScreen(movieId: Int, navController: NavController, viewModel: MovieDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val movie by viewModel.movieDetail.collectAsState()
    val isLoading by viewModel.loading.collectAsState()
    
    LaunchedEffect(movieId) {
        viewModel.fetchMovieDetail(movieId)
    }
    
    Column {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF4F7CCB))
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { navController.popBackStack() },
                tint = Color.White
            )

            Text(
                text = "Movie Info",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }

        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            movie?.let {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500${it.poster_path}",
                        contentDescription = "Google Image",
                        modifier = Modifier.size(150.dp)
                    )

                    Text(text = it.title, style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp), modifier = Modifier.padding(vertical = 5.dp))

                    Text(text = it.vote_average, style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.Red))

                    Text(text = it.release_date, style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.Red), modifier = Modifier.padding(vertical = 5.dp))
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                ) {
                    Text(text = "Overview", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp), modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = it.overview, style = TextStyle(fontSize = 14.sp))
                }
            }?: Text("Failed to load movie details.")
        }
    }
}