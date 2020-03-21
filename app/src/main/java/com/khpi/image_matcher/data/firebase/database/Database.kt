package com.khpi.image_matcher.data.firebase.database

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.khpi.image_matcher.data.models.MatchingModel
import com.khpi.image_matcher.data.utils.result.CODE_CANCELED
import com.khpi.image_matcher.data.utils.result.ErrorResult
import com.khpi.image_matcher.data.utils.result.PendingResult
import com.khpi.image_matcher.data.utils.result.Success
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class Database(private val firebase: FirebaseDatabase = Firebase.database) {

    companion object {
        private const val END_POINT = "questionary"
    }

    @ExperimentalCoroutinesApi
    suspend fun insert(session: String, model: MatchingModel) : PendingResult<*> = suspendCancellableCoroutine { continuation ->
        val child = "${System.currentTimeMillis()}"
        val session = "$END_POINT/session-$session"
        firebase.reference.child(session).child(child).setValue(model) { error, reference ->
            if (error == null) {
                continuation.resume(Success(Unit)) {
                    continuation.resume(ErrorResult(errorCode = CODE_CANCELED, message = it.message))
                }
            } else {
                continuation.resume(ErrorResult(errorCode = error.code, message = error.message))
            }
        }
    }

}