package com.example.testapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.testapp.data.model.Card
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

@Composable
fun ImageTitleDescriptionCard(card: Card) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(data = card.card.image?.url),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = card.card.title?.value ?: "",
                color = Color(android.graphics.Color.parseColor(card.card.title?.attributes?.text_color ?: "#000000")),
                fontSize = (card.card.title?.attributes?.font?.size ?: 16).sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = card.card.description?.value ?: "",
                color = Color(android.graphics.Color.parseColor(card.card.description?.attributes?.text_color ?: "#000000")),
                fontSize = (card.card.description?.attributes?.font?.size ?: 14).sp
            )
        }
    }
}
