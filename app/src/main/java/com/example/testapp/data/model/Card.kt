package com.example.testapp.data.model

data class Card(
    val card_type: String,
    val card: CardDetails
)

data class CardDetails(
    val value: String? = null,
    val attributes: Attributes? = null,
    val title: Title? = null,
    val description: Description? = null,
    val image: Image? = null
)

data class Attributes(
    val text_color: String,
    val font: Font
)

data class Font(
    val size: Int
)

data class Title(
    val value: String,
    val attributes: Attributes
)

data class Description(
    val value: String,
    val attributes: Attributes
)

data class Image(
    val url: String,
    val size: Size
)

data class Size(
    val width: Int,
    val height: Int
)
