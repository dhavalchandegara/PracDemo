package com.dc.demo.utility

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dc.demo.R

fun AppCompatImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .skipMemoryCache(false)
        .placeholder(R.drawable.placeholer)
        .into(this)
}

fun AppCompatImageView.circleLoadImage(url: String) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .skipMemoryCache(false)
        .circleCrop()
        .placeholder(R.drawable.placeholer)
        .into(this)
}

fun Resources.getCompatColor(color: Int): Int {
    return ResourcesCompat.getColor(this, color, null)
}

fun Resources.getCompatDrawable(drawable: Int): Drawable? {
    return ResourcesCompat.getDrawable(this, drawable, null)
}

fun <E> List<E>.containsItem(filterBy: ArrayList<E>): Boolean {
    this.forEach {
        if (filterBy.contains(it)) {
            return true
        }
    }
    return false
}


