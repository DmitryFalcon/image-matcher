package com.khpi.image_matcher.presentation.main.interfaces

import com.khpi.image_matcher.presentation.base.view.interfaces.BaseProgressiveView

interface QuestionaryView : BaseProgressiveView {

    fun navigateToMatchesScreen(data: Int)
}