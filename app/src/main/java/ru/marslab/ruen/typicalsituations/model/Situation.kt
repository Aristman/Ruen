package ru.marslab.ruen.typicalsituations.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Situation(
    val image: Int,
    val name: String,
    val firstRusPhrase: String,
    val firstEngPhrase: String,
    val secondRusPhrase: String,
    val secondEngPhrase: String
) : Parcelable
