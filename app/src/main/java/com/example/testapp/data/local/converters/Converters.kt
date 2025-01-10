package com.example.testapp.data.local.converters

import androidx.room.TypeConverter
import com.example.testapp.data.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    // Convert Attributes to String and vice versa
    @TypeConverter
    fun fromAttributes(attributes: Attributes?): String? {
        return gson.toJson(attributes)
    }

    @TypeConverter
    fun toAttributes(json: String?): Attributes? {
        return gson.fromJson(json, object : TypeToken<Attributes?>() {}.type)
    }

    // Convert Title to String and vice versa
    @TypeConverter
    fun fromTitle(title: Title?): String? {
        return gson.toJson(title)
    }

    @TypeConverter
    fun toTitle(json: String?): Title? {
        return gson.fromJson(json, object : TypeToken<Title?>() {}.type)
    }

    // Convert Description to String and vice versa
    @TypeConverter
    fun fromDescription(description: Description?): String? {
        return gson.toJson(description)
    }

    @TypeConverter
    fun toDescription(json: String?): Description? {
        return gson.fromJson(json, object : TypeToken<Description?>() {}.type)
    }

    // Convert Image to String and vice versa
    @TypeConverter
    fun fromImage(image: Image?): String? {
        return gson.toJson(image)
    }

    @TypeConverter
    fun toImage(json: String?): Image? {
        return gson.fromJson(json, object : TypeToken<Image?>() {}.type)
    }

    // Convert Font to String and vice versa
    @TypeConverter
    fun fromFont(font: Font?): String? {
        return gson.toJson(font)
    }

    @TypeConverter
    fun toFont(json: String?): Font? {
        return gson.fromJson(json, object : TypeToken<Font?>() {}.type)
    }

    // Convert Size to String and vice versa
    @TypeConverter
    fun fromSize(size: Size?): String? {
        return gson.toJson(size)
    }

    @TypeConverter
    fun toSize(json: String?): Size? {
        return gson.fromJson(json, object : TypeToken<Size?>() {}.type)
    }

    // Convert CardDetails to String and vice versa
    @TypeConverter
    fun fromCardDetails(cardDetails: CardDetails?): String? {
        return gson.toJson(cardDetails)
    }

    @TypeConverter
    fun toCardDetails(json: String?): CardDetails? {
        return gson.fromJson(json, object : TypeToken<CardDetails?>() {}.type)
    }
}
