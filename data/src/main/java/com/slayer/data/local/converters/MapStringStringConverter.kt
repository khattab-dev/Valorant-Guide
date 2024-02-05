package com.slayer.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MapStringStringConverter {

    @TypeConverter
    fun fromString(value: String?): Map<String, String>? {
        if (value == null) return null

        val mapType = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun toString(value: Map<String, String>?): String? {
        return Gson().toJson(value)
    }
}
