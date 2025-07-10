package com.example.spotflix.ui.screens
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotflix.ui.viewmodel.SearchViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import com.example.spotflix.ui.components.Header
import com.example.spotflix.ui.components.MovieCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var searchText by remember { mutableStateOf("") }
    val movies by viewModel.movies.collectAsState()
    val isLoading by viewModel.loading.collectAsState()
    val favoriteMovies by viewModel.favoriteMovies.collectAsState()

    Column {
        Header(title = "Find Movies", navController = { navController.popBackStack() })

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            TextField(
                textStyle = TextStyle(
                    fontSize = 16.sp,
                ),
                value = searchText,
                onValueChange = {
                    searchText = it
                    if (searchText.isNotBlank()) {
                        viewModel.search(searchText)
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .border(width = 1.5.dp, color = Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text("Search your movie") },
            )

            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
            LazyColumn {
                items(movies) { movie ->
                    MovieCard(
                        movie = movie,
                        isFavorite = favoriteMovies.any { it.id == movie.id },
                        onFavoriteClick = { viewModel.toggleFavorite(movie) },
                        onClick = { navController.navigate("detailsScreen/${movie.id}") }
                    )
                }
            }
            }
        }
    }
}