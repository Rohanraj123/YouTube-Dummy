package com.example.youtubedemo.view.screen

import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.navigation.NavBackStackEntry

@OptIn(UnstableApi::class)
@Composable
fun VideoDisplayScreen(backStackEntry: NavBackStackEntry) {
    val context = LocalContext.current

    val videoUrl = backStackEntry.arguments?.getString("videoUrl").toString().removeSurrounding("\"")
    val views = backStackEntry.arguments?.getString("views").toString().removeSurrounding("\"")
    val description = backStackEntry.arguments?.getString("description").toString().removeSurrounding("\"").replace("+", " ")
    val title = backStackEntry.arguments?.getString("title").toString().removeSurrounding("\"").replace("+", " ")
    val likes = backStackEntry.arguments?.getString("likes").toString().removeSurrounding("\"")

    Log.d("DisplayScreen", "Collected video url : $videoUrl")

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(videoUrl)))
            prepare()
            play()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9)
                .background(Color.Black)
                .clip(RoundedCornerShape(8.dp))
        ) {
            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        DisposableEffect(Unit) {
            onDispose {
                exoPlayer.release()
            }
        }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    maxLines = 2,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Views: ${views}", modifier = Modifier.padding(vertical = 4.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Likes: ${likes}", modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = "Description:",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = description,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                TextField(
                    value = "",
                    onValueChange = { /* Handle comment change */ },
                    placeholder = { Text(text = "Write a comment...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.LightGray,
                        unfocusedContainerColor = Color.LightGray
                    )
                )
            }
        }
}
