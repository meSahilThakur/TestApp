package com.example.testapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.data.model.Card

// Composable function to display cards based on their type.
@Composable
fun HomeCard(card: Card, modifier: Modifier = Modifier) {
    when (card.card_type) {
        "text" -> TextCard(card)
        "title_description" -> TitleDescriptionCard(card, modifier)
        "image_title_description" -> ImageTitleDescriptionCard(card, modifier)
        else -> {
            // Fallback for unknown card type
            Text(text = "Unknown card type", modifier = modifier)
        }
    }
}