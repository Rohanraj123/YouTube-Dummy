package com.example.youtubedemo.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.youtubedemo.ui.theme.ButtonColor

@Composable
fun VideoDisplayScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Video Display Area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9)
                .background(Color.Black)
        ) {
            // Your video player component goes here

        }

        // Likes, Share, Subscribe Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Handle like button click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Like")
            }
            Button(
                onClick = { /* Handle share button click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Share")
            }
            Button(
                onClick = { /* Handle subscribe button click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Subscribe")
            }
        }

        // Views, Comments, Description Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Views: 100K", modifier = Modifier.padding(vertical = 4.dp))
            Text(
                text = "Description:",
                modifier = Modifier
                    .padding(vertical = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod enim eu arcu ullamcorper tincidunt.",
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
        LazyColumn {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayScreenPreview() {
    VideoDisplayScreen()
}
