package com.app.tanvant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductResponse(val image: String = "",
                           val price: Double = 0.0,
                           val rating: Rating,
                           val description: String = "",
                           val id: Int = 0,
                           val title: String = "",
                           val category: String = "") : Parcelable