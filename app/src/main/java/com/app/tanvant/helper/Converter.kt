package com.app.tanvant.helper

import androidx.room.TypeConverter
import com.app.tanvant.model.Rating
import org.json.JSONObject

class Converter {

    @TypeConverter
    fun fromRating(rating: Rating): String {
        return JSONObject().apply {
            put("rate", rating.rate)
            put("count", rating.count)
        }.toString()
    }

    @TypeConverter
    fun toRating(rating: String): Rating {
        val json = JSONObject(rating)
        return Rating(json.get("rate") as Double, json.getInt("count"))
    }
}