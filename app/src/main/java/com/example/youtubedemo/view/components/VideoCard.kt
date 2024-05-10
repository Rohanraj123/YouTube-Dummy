package com.example.youtubedemo.view.components

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.youtubedemo.data.model.videos
import com.squareup.picasso.Picasso
import io.ktor.http.decodeURLPart
import io.ktor.http.encodeURLPath
import org.jetbrains.annotations.Async
import java.io.File
import javax.sql.DataSource

@Composable
fun VideoCard(
    video: videos,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {

        Column {

            // Video thumbnail
           LoadImageWithPicasso(
               imageUrl = video.thumbnail.trim().removeSurrounding("\""),
               modifier = Modifier
                   .fillMaxWidth()
                   .height(200.dp)
                   .clip(RoundedCornerShape(30.dp))
           )
            AsyncImage(
                model = video.thumbnail.trim(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Video title
            Text(
                text = video.title,
                fontSize = 18.sp,
                maxLines = 2,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Number of views
            Text(
                text = "Views: ${video.views}",
                fontSize = 14.sp,
                color = Color.White
            )
        }

        // Play button
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        )
    }
}

@Composable
fun LoadImageWithPicasso(imageUrl: String, modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        },
        update = { imageView ->
            Picasso.get()
                .load(imageUrl)
                .into(imageView, object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        // Image loaded successfully
                    }

                    override fun onError(e: Exception?) {
                        // Log the error message if image loading failed
                        Log.e("Picasso", "Image loading failed: ${e?.message}", e)
                    }
                })
        },
        modifier = modifier
    )
}