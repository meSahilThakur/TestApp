package com.example.testapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.data.model.Card
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage

@Composable
fun ImageTitleDescriptionCard(card: Card, modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(20.dp)
    ) {
        Box(modifier = Modifier) {

            AsyncImage(
                model = card.card.image?.url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp).align(Alignment.BottomStart)
            ) {
                Text(
                    text = card.card.title?.value ?: "",
                    color = Color(
                        android.graphics.Color.parseColor(
                            card.card.title?.attributes?.text_color ?: "#000000"
                        )
                    ),
                    fontSize = (card.card.title?.attributes?.font?.size ?: 16).sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = card.card.description?.value ?: "",
                    color = Color(
                        android.graphics.Color.parseColor(
                            card.card.description?.attributes?.text_color ?: "#000000"
                        )
                    ),
                    fontSize = (card.card.description?.attributes?.font?.size ?: 14).sp
                )
            }
        }
    }
}
