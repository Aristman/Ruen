package ru.marslab.ruen.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class GlideImageLoader constructor(): IImageLoader {
    override fun load(url: String, imageView: ImageView) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}