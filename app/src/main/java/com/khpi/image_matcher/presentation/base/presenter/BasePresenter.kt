package com.khpi.image_matcher.presentation.base.presenter

import com.khpi.image_matcher.data.coroutines.EXCEPTION_HANDLER
import com.khpi.image_matcher.presentation.base.view.interfaces.BaseView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T : BaseView> : MvpPresenter<T>(), CoroutineScope {

    private var rootJob: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main.immediate + rootJob + EXCEPTION_HANDLER
}