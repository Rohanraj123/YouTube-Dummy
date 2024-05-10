package com.example.youtubedemo.view.navigation

import androidx.compose.runtime.Composable
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
            route = "display_screen/{videoUrl}/{views}/{description}/{title}/{likes}",
            arguments = listOf(
                navArgument("videoUrl") { type = NavType.StringType },
                navArgument("views") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType },
                navArgument("likes") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            VideoDisplayScreen(backStackEntry)
        }
    }
}