package com.app.tanvant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(val rate: Double = 0.0,
                  val count: Int = 0) : Parcelable