package com.khpi.image_matcher.presentation.base.view.interfaces

import moxy.MvpView

interface BaseView : MvpView {

    fun showSuccessDialog(title: String, content: String? = null)

    fun showErrorDialog(title: String, content: String? = null)

    fun showErrorDialog(content: String? = null)
}