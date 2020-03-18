package com.khpi.image_matcher.data.utils.result

sealed class PendingResult<T>(val data: T)

class Success<T>(data: T) : PendingResult<T>(data)

class ErrorResult(val errorCode: Int, message: String?) : PendingResult<String?>(message)