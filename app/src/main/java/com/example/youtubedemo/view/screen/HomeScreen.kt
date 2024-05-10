package com.example.youtubedemo.view.screen

import android.util.Log
import android.util.Pair
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.youtubedemo.R
import com.example.youtubedemo.view.components.FlatButton
import com.example.youtubedemo.view.components.TopAppBar
import com.example.youtubedemo.view.components.VideoCard
import com.example.youtubedemo.viewmodel.SupaBaseViewModel
import java.io.File
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomeScreen(
    supabaseViewModel: SupaBaseViewModel,
    navController: NavHostController
) {


    val videosState by remember { supabaseViewModel.videos }.collectAsState()

    DisposableEffect(Unit) {
        supabaseViewModel.getVideos()
        onDispose { }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopAppBar(
            onClick = {/* Handle search functionality */}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            FlatButton(
                title = stringResource(id = R.string.Hot),
                isSelected = true,
                onClick = {}
            )
            FlatButton(
                title = stringResource(id = R.string.funny),
                isSelected = false,
                onClick = {}
            )
            FlatButton(
                title = stringResource(id = R.string.Information),
                isSelected = false,
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(videosState) { video ->
                val encodeUrl = URLEncoder.encode(video.video, StandardCharsets.UTF_8.toString())

                Log.d("HomeScreen", "video url : ${video.video}")
                VideoCard(
                    video,
                    onClick = {

                        navController.navigate("display_screen/${encodeUrl}")
                        Log.d("HomeScreen", "Navigation started with video : $video")
                    }
                )
            }
        }
    }
}


