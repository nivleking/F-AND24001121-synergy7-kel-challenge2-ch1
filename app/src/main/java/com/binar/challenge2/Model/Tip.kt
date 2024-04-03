package com.binar.challenge2.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tip(
    val price: Int,
    val tip: Double
) : Parcelable {
}