package com.example.youtubedemo.view.screen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtubedemo.R
import com.example.youtubedemo.view.components.FlatButton
import com.example.youtubedemo.view.components.TopAppBar
import com.example.youtubedemo.view.components.VideoCard
import com.example.youtubedemo.viewmodel.SupaBaseViewModel

@Composable
fun HomeScreen(
    supabaseViewModel: SupaBaseViewModel
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopAppBar(
            onClick = {/* Handle search functionality */}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /* Handle this shit */ }) {
            Text(text = "Click here to insert")
        }
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
            items(1) { index ->

                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Survival on island for 100 days without any resources",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Aman Dhattarwal",
                    videoTitle = "How to clear jee exam in 2 years",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
                VideoCard(
                    channelLogo = painterResource(id = R.drawable.appicon),
                    channelName = "Mr. Beast",
                    videoTitle = "Video Title $index",
                    thumbnail = painterResource(id = R.drawable.ic_launcher_background),
                    numberOfViews = 1000,
                    onClick = {
                        // Handle card click here (navigate to Display screen)
                    }
                )
            }
        }
    }
}
