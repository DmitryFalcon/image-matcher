package com.khpi.image_matcher.presentation.base.view.implementation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.khpi.image_matcher.presentation.base.view.implementation.activities.BaseActivity
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseView
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    abstract val layoutResId: Int
        @LayoutRes get

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun showSuccessDialog(title: String, content: String?) {
        (activity as? BaseActivity)?.showSuccessDialog(title, content)
    }

    override fun showErrorDialog(title: String, content: String?) {
        (activity as? BaseActivity)?.showErrorDialog(title, content)
    }

    override fun showErrorDialog(content: String?) {
        (activity as? BaseActivity)?.showErrorDialog(content)
    }

}