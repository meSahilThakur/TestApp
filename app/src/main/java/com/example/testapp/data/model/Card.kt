package com.example.testapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val card_type: String,
    val card: CardDetails
)

@Serializable
data class CardDetails(
    val value: String? = null,
    val attributes: Attributes? = null,
    val title: Title? = null,
    val description: Description? = null,
    val image: Image? = null
)

@Serializable
data class Attributes(
    val text_color: String,
    val font: Font
)

@Serializable
data class Font(
    val size: Int
)

@Serializable
data class Title(
    val value: String,
    val attributes: Attributes
)

@Serializable
data class Description(
    val value: String,
    val attributes: Attributes
)

@Serializable
data class Image(
    val url: String,
    val size: Size
)

@Serializable
data class Size(
    val width: Int,
    val height: Int
)
