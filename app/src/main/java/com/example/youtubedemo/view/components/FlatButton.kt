package com.example.youtubedemo.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.youtubedemo.ui.theme.ButtonColor

@Composable
fun FlatButton(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isSelected) ButtonColor else Color.Gray
        )
    ) {
        Text(
            text = title,
            color = if (isSelected) Color.Black else Color.White,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}