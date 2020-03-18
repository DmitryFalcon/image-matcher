package com.khpi.image_matcher.presentation.match.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.StorageReference
import com.khpi.image_matcher.R
import com.khpi.image_matcher.android.list.BaseViewHolder
import com.khpi.image_matcher.android.list.ItemClickListener

class ImageViewHolder(view: View) : BaseViewHolder<StorageReference>(view) {

    private val imageView: ImageView = view.findViewById(R.id.image_content)

    override fun bindView(
        item: StorageReference,
        itemClickListener: ItemClickListener<StorageReference>?
    ) {
        Glide.with(itemView.context)
            .load(item)
            .into(imageView)
    }
}