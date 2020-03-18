package com.khpi.image_matcher.presentation.base.presenter

import com.khpi.image_matcher.presentation.base.view.interfaces.BaseProgressiveView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class BaseProgressivePresenter<T : BaseProgressiveView> : BasePresenter<T>() {

    fun execute(context: CoroutineContext = Dispatchers.Main, block: suspend () -> Unit) {
        launch(context) { block() }
    }

    suspend inline fun <T> progressive(crossinline block: suspend () -> T): T {
        return try {
            viewState.showProgress()
            withContext(Dispatchers.IO) { block() }
        } finally {
            viewState.hideProgress()
        }
    }
}