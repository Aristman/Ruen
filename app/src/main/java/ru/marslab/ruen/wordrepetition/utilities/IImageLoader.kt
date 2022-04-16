package ru.marslab.ruen.wordrepetition.utilities

import android.widget.ImageView

interface IImageLoader {
    fun load(url: String, imageView: ImageView)
}
