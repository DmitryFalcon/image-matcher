package com.khpi.image_matcher.data.firebase.storage

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.khpi.image_matcher.data.utils.result.*
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class Storage(private val firebaseStorage: FirebaseStorage = Firebase.storage) {

    suspend fun loadAll(): PendingResult<*> = suspendCancellableCoroutine { continuation ->
        firebaseStorage.reference.listAll()
            .addOnSuccessListener { continuation.resume(Success(it.items)) }
            .addOnCanceledListener { continuation.resume(ErrorResult(CODE_CANCELED, null)) }
            .addOnFailureListener { continuation.resume(ErrorResult(CODE_UNDEFINED, it.message)) }
    }

}