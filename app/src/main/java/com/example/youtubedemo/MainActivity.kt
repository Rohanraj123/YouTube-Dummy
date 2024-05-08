package com.example.youtubedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.youtubedemo.ui.theme.YoutubeDemoTheme
import com.example.youtubedemo.view.navigation.Navigation
import com.example.youtubedemo.viewmodel.SupaBaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

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
