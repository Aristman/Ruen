package ru.marslab.ruen.utilities

import android.widget.ImageView

interface IImageLoader {
    fun load(url: String, into: ImageView)
}