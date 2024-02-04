package com.slayer.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.slayer.domain.models.agents.AgentAbilityModel


class AgentAbilityListConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String?): List<AgentAbilityModel>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<AgentAbilityModel>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<AgentAbilityModel>?): String? {
        return gson.toJson(list)
    }
}
