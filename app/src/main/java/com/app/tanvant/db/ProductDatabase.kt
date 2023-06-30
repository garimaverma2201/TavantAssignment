package com.app.tanvant.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.tanvant.helper.Converter
import com.app.tanvant.model.ProductResponse

@Database(entities = [ProductResponse::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ProductDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao
}
