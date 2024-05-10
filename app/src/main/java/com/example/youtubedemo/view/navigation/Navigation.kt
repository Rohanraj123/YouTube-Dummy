package com.example.youtubedemo.view.navigation

import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.youtubedemo.view.screen.HomeScreen
import com.example.youtubedemo.view.screen.VideoDisplayScreen
import com.example.youtubedemo.viewmodel.SupaBaseViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    supaBaseViewModel: SupaBaseViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {

            HomeScreen(supaBaseViewModel, navController)
        }
        composable(
            route = "display_screen/{video}",
            arguments = listOf(navArgument("video") { type = NavType.StringType })
        ) { backStackEntry ->
            VideoDisplayScreen(backStackEntry)
        }
    }
}