package ru.marslab.ruen.typicalsituations.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Situations(
    val situationImage: Int,
    val situationName: String,
    val firstRusPhrase: String,
    val firstEngPhrase: String,
    val secondRusPhrase: String,
    val secondEngPhrase: String
) : Parcelable
