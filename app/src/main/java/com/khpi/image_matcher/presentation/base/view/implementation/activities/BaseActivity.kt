package com.khpi.image_matcher.presentation.base.view.implementation.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.afollestad.materialdialogs.MaterialDialog
import com.khpi.image_matcher.R
import com.khpi.image_matcher.presentation.base.view.implementation.fragments.BaseFragment
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseView
import moxy.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    var currentFragment: BaseFragment? = null
        private set

    open val contentResId: Int = R.layout.activity_base
        @LayoutRes get

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentResId)
    }

    override fun showSuccessDialog(title: String, content: String?) {
        MaterialDialog(this).show {
            title(text = title)
            message(text = content)
        }
    }

    override fun showErrorDialog(title: String, content: String?) {
        MaterialDialog(this).show {
            title(text = title)
            message(text = content)
        }
    }

    override fun showErrorDialog(content: String?) {
        MaterialDialog(this).show {
            title(R.string.title_default_error)
            message(text = content)
        }
    }

    protected fun showFragment(fragment: BaseFragment, addToBackStack: Boolean = false) {
        val tag = fragment.javaClass.canonicalName
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout_fragment_holder, fragment, tag)
        transaction.takeIf { addToBackStack }?.addToBackStack(tag)
        transaction.commit()
        currentFragment = fragment
    }
}