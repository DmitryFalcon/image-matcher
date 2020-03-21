package com.khpi.image_matcher.presentation.match.implementation

import com.google.firebase.storage.StorageReference
import com.khpi.image_matcher.data.firebase.database.Database
import com.khpi.image_matcher.data.firebase.storage.Storage
import com.khpi.image_matcher.data.models.MatchingModel
import com.khpi.image_matcher.data.utils.result.ErrorResult
import com.khpi.image_matcher.data.utils.result.Success
import com.khpi.image_matcher.presentation.base.presenter.BaseProgressivePresenter
import com.khpi.image_matcher.presentation.match.interfaces.ImageMatcherView
import moxy.InjectViewState
import kotlin.random.Random

@InjectViewState
class ImageMatcherPresenter(
    private val database: Database,
    private val storage: Storage
) : BaseProgressivePresenter<ImageMatcherView>() {

    var data: Int = 0

    private val random = Random.Default
    private var items: List<StorageReference> = emptyList()
    private val session: String = "${System.currentTimeMillis()}"

    override fun onFirstViewAttach() = execute {
        super.onFirstViewAttach()
        items = when (val result = progressive { storage.loadAll() }) {
            is Success<*> -> result.data as List<StorageReference>
            is ErrorResult -> {
                viewState.showErrorDialog(result.data)
                return@execute
            }
        }
        val showingItems = loadUrls()
        viewState.onImagesReady(showingItems)
    }

    fun submitAnswer(images: List<StorageReference>, isMatched: Boolean) = execute {
        val data = MatchingModel(images.first().name, images.last().name, isMatched, data)
        val result = progressive { database.insert(session, data) }
        if (result is ErrorResult) {
            viewState.showErrorDialog(result.data)
        }
        val items = loadUrls()
        viewState.onImagesReady(items)
    }


    suspend fun loadUrls(): List<StorageReference> = progressive {
        val first = random.nextInt(0, items.lastIndex)
        val second = random.nextInt(0, items.lastIndex)
        listOf(items[first], items[second])
    }
}