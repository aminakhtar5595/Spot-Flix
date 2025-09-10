package com.example.spotflix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spotflix.ui.screens.DetailsScreen
import com.example.spotflix.ui.screens.FavoriteScreen
import com.example.spotflix.ui.screens.HomeScreen
import com.example.spotflix.ui.screens.SearchScreen
import com.example.spotflix.ui.viewmodel.SearchViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val searchViewModel: SearchViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) {
            SearchScreen(navController, searchViewModel)
        }
        composable(Screen.Favorite.route) {
            FavoriteScreen(navController, searchViewModel)
        }
        composable("detailsScreen/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: return@composable
            DetailsScreen(movieId = movieId, navController = navController)
        }

    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Search : Screen("searchScreen")
    object Favorite : Screen("favoriteScreen")
    object Details : Screen("detailsScreen")
}