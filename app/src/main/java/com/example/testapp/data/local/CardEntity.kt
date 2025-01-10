package com.example.testapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.testapp.data.local.converters.Converters
import com.example.testapp.data.model.CardDetails

@Entity(tableName = "cards")
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val card_type: String,

    @TypeConverters(Converters::class)
    val card: CardDetails
)