package com.rja.apisapp

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader(private val context: Context) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .into(imageView)
    }
}