package com.khpi.image_matcher.presentation.main.implementation

import com.khpi.image_matcher.R
import com.khpi.image_matcher.domain.user.*
import com.khpi.image_matcher.presentation.base.presenter.BaseProgressivePresenter
import com.khpi.image_matcher.presentation.main.interfaces.QuestionaryView
import moxy.InjectViewState

@InjectViewState
class QuestionaryPresenter : BaseProgressivePresenter<QuestionaryView>() {

    private var sex: Int = MALE
    private var age: Int = AGE_YOUNG

    fun changeSex(id: Int) {
        sex = when (id) {
            R.id.radio_sex_male -> MALE
            R.id.radio_sex_female -> FEMALE
            else -> throw IllegalArgumentException()
        }
    }

    fun changeAge(id: Int) {
        age = when (id) {
            R.id.radio_age_young -> AGE_YOUNG
            R.id.radio_age_middle -> AGE_MIDDLE
            R.id.radio_age_older -> AGE_OLDER
            else -> throw IllegalArgumentException()
        }
    }

    fun accept() {
        var data = 0
        data = data shl SEX_VALUE_OFFSET
        data = data or sex
        data = data shl AGE_VALUE_OFFSET
        data = data or age
        viewState.navigateToMatchesScreen(data)
    }

}