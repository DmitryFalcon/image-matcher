package com.khpi.image_matcher.presentation.main

import android.os.Bundle
import com.khpi.image_matcher.presentation.base.view.implementation.activities.BaseProgressiveActivity
import com.khpi.image_matcher.presentation.main.implementation.QuestionaryFragment

class MainActivity : BaseProgressiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragment(QuestionaryFragment.newInstance(QuestionaryFragment.arguments()))
    }
}