package com.example.testapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.data.model.Card
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults


@Composable
fun TextCard(card: Card) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Text(
            text = card.card.value ?: "",
            color = Color(android.graphics.Color.parseColor(card.card.attributes?.text_color ?: "#000000")),
            fontSize = (card.card.attributes?.font?.size ?: 16).sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}