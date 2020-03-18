package com.khpi.image_matcher.presentation.match.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.firebase.storage.StorageReference
import com.khpi.image_matcher.R
import com.khpi.image_matcher.android.list.BaseRecyclerViewAdapter

class ImagesAdapter : BaseRecyclerViewAdapter<StorageReference, ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }
}