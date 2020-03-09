package com.khpi.image_matcher

import android.app.Application
import timber.log.Timber

class ImageMatcherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}