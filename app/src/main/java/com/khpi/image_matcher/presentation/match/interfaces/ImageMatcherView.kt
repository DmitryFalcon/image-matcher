package com.khpi.image_matcher.presentation.match.interfaces

import com.google.firebase.storage.StorageReference
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseProgressiveView

interface ImageMatcherView : BaseProgressiveView {

    fun onImagesReady(images: List<StorageReference>)
}