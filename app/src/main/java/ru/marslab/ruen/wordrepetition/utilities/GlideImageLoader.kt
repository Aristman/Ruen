package ru.marslab.ruen.wordrepetition.utilities

import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.marslab.ruen.R

class GlideImageLoader() :
    IImageLoader {
    override fun load(url: String, imageView: ImageView) {
        val resources = imageView.context.resources
        val radius = resources.getDimensionPixelSize(R.dimen.card_corner_radius)
        Glide.with(imageView.context)
            .load(url)
            .error(ResourcesCompat.getDrawable(resources, R.drawable.ic_no_photo, null))
            .transform(RoundedCorners(radius))
            .into(imageView)
    }
}
