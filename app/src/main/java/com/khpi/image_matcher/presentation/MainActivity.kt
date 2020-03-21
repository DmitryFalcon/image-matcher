package com.khpi.image_matcher.presentation

import android.os.Bundle
import com.khpi.image_matcher.presentation.base.view.implementation.activities.BaseProgressiveActivity
import com.khpi.image_matcher.presentation.main.implementation.QuestionaryFragment
import com.khpi.image_matcher.presentation.match.implementation.ImageMatcherFragment
import com.khpi.image_matcher.presentation.preview.implementation.PreviewFragment

class MainActivity : BaseProgressiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragment(PreviewFragment.newInstance())
    }

    fun navigateToMatchingScreen(data: Int) {
        val arguments = ImageMatcherFragment.arguments(data)
        showFragment(ImageMatcherFragment.newInstance(arguments))
    }

    fun navigateToQuestionary() {
        showFragment(QuestionaryFragment.newInstance(QuestionaryFragment.arguments()))
    }
}