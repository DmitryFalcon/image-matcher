package com.khpi.image_matcher.presentation.preview.implementation

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.khpi.image_matcher.R
import com.khpi.image_matcher.presentation.base.view.implementation.fragments.BaseProgressiveFragment
import com.khpi.image_matcher.presentation.MainActivity
import com.khpi.image_matcher.presentation.preview.interfaces.PreviewView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PreviewFragment : BaseProgressiveFragment(), PreviewView {

    companion object {
        fun newInstance() :PreviewFragment {
            val fragment = PreviewFragment()
            return fragment
        }
    }

    private lateinit var nextButton: Button

    @InjectPresenter
    lateinit var previewPresenter: PreviewPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextButton = view.findViewById(R.id.button_next)
        nextButton.setOnClickListener {
            previewPresenter.navigateToQuestionatry()
        }
    }

    override val layoutResId: Int = R.layout.fragment_preview

    @ProvidePresenter
    fun providePresenter(): PreviewPresenter {
        return PreviewPresenter()
    }

    override fun navigateToQuestionatry() {
        (activity as? MainActivity)?.navigateToQuestionary()
    }

}
