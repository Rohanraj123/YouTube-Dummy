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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.youtubedemo.R

@Composable
fun TopAppBar(
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.PlayArrow,
            contentDescription = stringResource(id = R.string.app_icon),
            tint = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Vidzy",
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )

    }
}