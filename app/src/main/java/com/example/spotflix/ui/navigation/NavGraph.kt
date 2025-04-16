package com.example.spotflix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spotflix.ui.screens.DetailsScreen
import com.example.spotflix.ui.screens.FavoriteScreen
import com.example.spotflix.ui.screens.HomeScreen
import com.example.spotflix.ui.screens.SearchScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.Details.route) { DetailsScreen(navController) }
        composable(Screen.Favorite.route) { FavoriteScreen(navController) }
    }
}

// Enum-like class for routes
sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object Search : Screen("searchScreen")
    object Favorite : Screen("favoriteScreen")
    object Details : Screen("detailsScreen")
}