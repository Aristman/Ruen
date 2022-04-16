package ru.marslab.ruen.wordrepetition.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.marslab.ruen.wordrepetition.utilities.DateProvider
import java.util.Date

@Parcelize
data class Card(
    var id: Long? = null,
    var value: String,
    var imageUrl: String? = null,
    var transcription: String? = null,
    var sound: String? = null,
    var translations: MutableList<Translation>? = null,
    var nextDateRepeating: Date = DateProvider().getCurrentDateWithoutTime(),
    var countRepeat: Int = 0
) : Parcelable
