package com.khpi.image_matcher.presentation.match.implementation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.StorageReference
import com.khpi.image_matcher.R
import com.khpi.image_matcher.android.list.decoration.GridItemMarginDecoration
import com.khpi.image_matcher.data.firebase.database.Database
import com.khpi.image_matcher.data.firebase.storage.Storage
import com.khpi.image_matcher.presentation.base.view.implementation.fragments.BaseProgressiveFragment
import com.khpi.image_matcher.presentation.match.interfaces.ImageMatcherView
import com.khpi.image_matcher.presentation.match.utils.ImagesAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ImageMatcherFragment : BaseProgressiveFragment(), ImageMatcherView {

    companion object {

        private const val KEY_DATA = "data"

        fun arguments(data: Int): Bundle {
            return Bundle().apply { putInt(KEY_DATA, data) }
        }

        fun newInstance(arguments: Bundle): ImageMatcherFragment {
            val fragment = ImageMatcherFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    @InjectPresenter
    lateinit var presenter: ImageMatcherPresenter

    private val adapter = ImagesAdapter()

    private lateinit var recyclerView: RecyclerView
    private lateinit var matchedButton: Button
    private lateinit var notMatchedButton: Button
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.data = arguments?.getInt(KEY_DATA, 0) ?: 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchedButton = view.findViewById(R.id.button_matched)
        matchedButton.setOnClickListener {
            presenter.submitAnswer(adapter.items, true)
        }
        notMatchedButton = view.findViewById(R.id.button_not_matched)
        notMatchedButton.setOnClickListener {
            presenter.submitAnswer(adapter.items, false)
        }
        finishButton = view.findViewById(R.id.button_finish)
        finishButton.setOnClickListener {
            activity?.finish()
        }
        val margins = resources.getDimensionPixelOffset(R.dimen.margin_16)
        val decoration = GridItemMarginDecoration(margins, 2)
        recyclerView = view.findViewById(R.id.list_images)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.addItemDecoration(decoration)
        recyclerView.adapter = adapter
    }

    override val layoutResId: Int = R.layout.fragment_matching

    override fun onImagesReady(images: List<StorageReference>) {
        adapter.items = images
    }

    @ProvidePresenter
    fun injectPresenter(): ImageMatcherPresenter {
        return ImageMatcherPresenter(Database(), Storage())
    }
}