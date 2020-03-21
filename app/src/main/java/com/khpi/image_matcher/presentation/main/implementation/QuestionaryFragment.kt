package com.khpi.image_matcher.presentation.main.implementation

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.khpi.image_matcher.R
import com.khpi.image_matcher.presentation.base.view.implementation.fragments.BaseProgressiveFragment
import com.khpi.image_matcher.presentation.MainActivity
import com.khpi.image_matcher.presentation.main.interfaces.QuestionaryView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class QuestionaryFragment : BaseProgressiveFragment(), QuestionaryView {

    companion object {
        fun arguments() = Bundle()

        fun newInstance(arguments: Bundle): QuestionaryFragment {
            val fragment = QuestionaryFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    @InjectPresenter
    lateinit var presenter: QuestionaryPresenter

    private lateinit var sexRadioGroup: RadioGroup
    private lateinit var ageRadioGroup: RadioGroup
    private lateinit var acceptButton: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sexRadioGroup = view.findViewById(R.id.layout_sex_radios)
        sexRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            presenter.changeSex(checkedId)
        }
        ageRadioGroup = view.findViewById(R.id.layout_age_radios)
        ageRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            presenter.changeAge(checkedId)
        }
        acceptButton = view.findViewById(R.id.button_accept)
        acceptButton.setOnClickListener {
            presenter.accept()
        }
    }

    override val layoutResId: Int = R.layout.fragment_questionary

    override fun navigateToMatchesScreen(data: Int) {
        (activity as? MainActivity)?.navigateToMatchingScreen(data)
    }

    @ProvidePresenter
    fun injectPresenter(): QuestionaryPresenter {
        return QuestionaryPresenter()
    }
}