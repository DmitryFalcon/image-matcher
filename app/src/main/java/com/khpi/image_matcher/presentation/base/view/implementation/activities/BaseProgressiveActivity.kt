package com.khpi.image_matcher.presentation.base.view.implementation.activities

import android.os.Bundle
import androidx.core.widget.ContentLoadingProgressBar
import com.khpi.image_matcher.R
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseProgressiveView

abstract class BaseProgressiveActivity : BaseActivity(), BaseProgressiveView {

    private var progressView: ContentLoadingProgressBar? = null

    override val contentResId: Int = R.layout.activity_progressive

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressView = findViewById(R.id.progress_view)
    }

    override fun showProgress() {
        progressView?.show()
    }

    override fun hideProgress() {
        progressView?.hide()
    }

}