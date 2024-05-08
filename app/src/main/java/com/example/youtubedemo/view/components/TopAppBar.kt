package com.example.youtubedemo.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtubedemo.R

@Composable
fun TopAppBar(
    onClick: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Default.PlayArrow,
            contentDescription = stringResource(id = R.string.app_icon),
            tint = Color.White,
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            modifier = Modifier
                .padding(10.dp),
            fontSize = 30.sp
        )
        IconButton(onClick = { onClick() }) {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_icon),
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}