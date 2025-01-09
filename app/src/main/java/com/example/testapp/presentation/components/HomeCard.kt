package com.example.testapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.testapp.data.model.Card

// Composable function to display cards based on their type.
@Composable
fun HomeCard(card: Card) {
    when (card.card_type) {
        "text" -> TextCard(card)
        "title_description" -> TitleDescriptionCard(card)
        "image_title_description" -> ImageTitleDescriptionCard(card)
        else -> {
            // Fallback for unknown card type
            Text(text = "Unknown card type")
        }
    }
}