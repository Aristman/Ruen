package ru.marslab.ruen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    var id: Long? = null,
    var value: String,
    var imageUrl: String? = null,
    var transcription: String? = null,
    var sound: String? = null,
    var translations: MutableList<Translation>? = null,
) : Parcelable