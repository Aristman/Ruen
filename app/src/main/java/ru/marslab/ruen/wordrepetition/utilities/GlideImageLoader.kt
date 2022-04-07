package ru.marslab.ruen.wordrepetition.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.marslab.ruen.R


class GlideImageLoader() :
    IImageLoader {
    override fun load(url: String, imageView: ImageView) {
        val radius = imageView.context.resources.getDimensionPixelSize(R.dimen.card_corner_radius)
        Glide.with(imageView.context)
            .load(url)
            .centerCrop()
            .transform(RoundedCorners(radius))
            .into(imageView)
    }
}