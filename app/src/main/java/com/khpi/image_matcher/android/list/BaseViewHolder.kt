package com.khpi.image_matcher.android.list

import android.view.View

abstract class BaseViewHolder<T>(view: View) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    open fun bindView(item: T, itemClickListener: ItemClickListener<T>?) {
        itemView.setOnClickListener {
            itemClickListener?.onItemClick(item!!, adapterPosition)
        }
    }

    open fun unbindView() {
        itemView.setOnClickListener(null)
    }
}