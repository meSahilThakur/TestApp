package com.example.testapp.presentation.navigation

import com.example.testapp.data.model.CardDetails
import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
data class DetailScreen(
    val card: CardDetails
//    val value: String? = null,
//    val attributes: Attributes? = null,
//    val title: Title? = null,
//    val description: Description? = null,
//    val image: Image? = null
)