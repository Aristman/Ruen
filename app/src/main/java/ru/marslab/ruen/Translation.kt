package ru.marslab.ruen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translation(
    var id: Long? = null,
    var value: String,
    var cardId: Long? = null
) : Parcelable
