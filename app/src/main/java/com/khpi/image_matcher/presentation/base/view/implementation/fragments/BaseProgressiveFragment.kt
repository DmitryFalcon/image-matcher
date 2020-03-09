package com.khpi.image_matcher.presentation.base.view.implementation.fragments

import com.khpi.image_matcher.presentation.base.view.implementation.activities.BaseProgressiveActivity
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseProgressiveView

abstract class BaseProgressiveFragment : BaseFragment(), BaseProgressiveView {

    override fun showProgress() {
        (activity as? BaseProgressiveActivity)?.showProgress()
    }

    override fun hideProgress() {
        (activity as? BaseProgressiveActivity)?.hideProgress()
    }

}