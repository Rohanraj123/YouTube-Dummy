package com.example.youtubedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.youtubedemo.ui.theme.YoutubeDemoTheme
import com.example.youtubedemo.view.navigation.Navigation
import com.example.youtubedemo.viewmodel.SupaBaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeDemoTheme {
                val navController = rememberNavController()
                val supaBaseViewModel = hiltViewModel<SupaBaseViewModel>()
                Navigation(
                    navController = navController,
                    supaBaseViewModel
                )
            }
        }
    }
}   
