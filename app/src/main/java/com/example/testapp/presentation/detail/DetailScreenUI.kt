package com.example.testapp.presentation.detail

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.testapp.data.model.CardDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenUI(
    navController: NavHostController,
//    value: String?,
//    attributes: Attributes?,
//    title: Title?,
//    description: Description?,
//    image: Image?
    cardDetails: CardDetails
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {
            AsyncImage(
                model = cardDetails.image?.url,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp)
                    .size(40.dp)
                    .background(Color.White.copy(0.5f), shape = CircleShape)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black,
                )
            }
            IconButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, "Check out this card!")
                        val shareText = buildString {
                            append("Title: ${cardDetails.title?.value.orEmpty()}\n")
                            append("Description: ${cardDetails.description?.value.orEmpty()}\n")
                            append("Image: ${cardDetails.image?.url.orEmpty()}\n")
                        }
                        putExtra(Intent.EXTRA_TEXT, shareText)
                    }
                    context.startActivity(
                        Intent.createChooser(shareIntent, "Share Card Details")
                    )
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(15.dp)
                    .size(40.dp)
                    .background(Color.White.copy(0.5f), shape = CircleShape)
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = "Title: ${cardDetails.title?.value}")
            Text(text = "Description: ${cardDetails.description?.value}")
        }
    }
}