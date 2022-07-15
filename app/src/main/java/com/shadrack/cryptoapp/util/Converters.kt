package com.shadrack.cryptoapp.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shadrack.cryptoapp.data.datasource.local.entity.Metrics

class Converters {


        @TypeConverter
        fun fromMetrics(value: Metrics): String {
            val gson = Gson()
            val type = object : TypeToken<Metrics>() {}.type
            return gson.toJson(value, type)
        }

        @TypeConverter
        fun toMetrics(value: String): Metrics {
            val gson = Gson()
            val type = object : TypeToken<Metrics>() {}.type
            return gson.fromJson(value, type)
        }




}