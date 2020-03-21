package com.khpi.image_matcher.presentation.preview.implementation

import com.khpi.image_matcher.presentation.base.presenter.BaseProgressivePresenter
import com.khpi.image_matcher.presentation.preview.interfaces.PreviewView
import moxy.InjectViewState
import moxy.presenter.InjectPresenter

@InjectViewState
class PreviewPresenter : BaseProgressivePresenter<PreviewView>() {

    fun navigateToQuestionatry() {
        viewState.navigateToQuestionatry()
    }
}