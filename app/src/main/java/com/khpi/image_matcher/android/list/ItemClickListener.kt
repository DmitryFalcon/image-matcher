package com.khpi.image_matcher.android.list

interface ItemClickListener<T> {

    fun onItemClick(item: T, position: Int)

}