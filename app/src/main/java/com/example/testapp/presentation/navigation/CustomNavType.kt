package com.example.testapp.presentation.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.testapp.data.model.CardDetails
import kotlinx.serialization.json.Json

object CustomNavType {
    val CardDetailType = object : NavType<CardDetails>(
        isNullableAllowed = false
    ){

        override fun get(bundle: Bundle, key: String): CardDetails? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): CardDetails {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: CardDetails): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: CardDetails) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }
}
