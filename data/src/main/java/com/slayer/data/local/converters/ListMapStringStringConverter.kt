package com.slayer.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListMapStringStringConverter {

    @TypeConverter
    fun fromString(value: String?): List<Map<String, String>>? {
        if (value == null) return null

        val listType = object : TypeToken<List<Map<String, String>>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(value: List<Map<String, String>>?): String? {
        return Gson().toJson(value)
    }
}
