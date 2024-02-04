package com.slayer.data.local.converters

import androidx.room.TypeConverter

class LongListConverter {
    @TypeConverter
    fun fromString(value: String?): List<Long>? {
        if (value == null) {
            return null
        }
        val items = value.split(",").map { it.toLong() }
        return items.toList()
    }

    @TypeConverter
    fun toString(items: List<Long>?): String? {
        return items?.joinToString(",")
    }
}