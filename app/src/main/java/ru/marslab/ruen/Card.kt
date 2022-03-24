package ru.marslab.ruen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.marslab.ruen.utilities.DateProvider
import java.util.*

@Parcelize
data class Card(
    var id: Long? = null,
    var value: String,
    var imageUrl: String? = null,
    var transcription: String? = null,
    var sound: String? = null,
    var translations: MutableList<Translation>? = null,
    var nextDateRepeating: Date = DateProvider().getCurrentDateWithoutTime(),
    var countRepeat: Int = -1
) : Parcelable