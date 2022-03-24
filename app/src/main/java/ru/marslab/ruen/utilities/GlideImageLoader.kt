package ru.marslab.ruen.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : IImageLoader {
    override fun load(url: String, imageView: ImageView) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}