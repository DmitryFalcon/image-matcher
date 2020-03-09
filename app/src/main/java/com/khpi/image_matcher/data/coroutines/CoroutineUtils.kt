package com.khpi.image_matcher.data.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

private const val TAG_EXCEPTION = "exception"

val EXCEPTION_HANDLER = CoroutineExceptionHandler { _, exception ->
    Timber.tag(TAG_EXCEPTION).e(exception)
}