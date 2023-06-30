package com.app.tanvant.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "product")
data class ProductResponse(val image: String = "",
                           val price: Double = 0.0,
                           val rating: Rating,
                           val description: String = "",
                           @PrimaryKey(autoGenerate = false)
                           val id: Int = 0,
                           val title: String = "",
                           val category: String = "") : Parcelable