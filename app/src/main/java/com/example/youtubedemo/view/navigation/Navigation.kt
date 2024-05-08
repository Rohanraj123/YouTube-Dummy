package com.example.youtubedemo.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            HomeScreen(supaBaseViewModel)
        }
        composable("display_screen") {
            VideoDisplayScreen()
        }
    }
}