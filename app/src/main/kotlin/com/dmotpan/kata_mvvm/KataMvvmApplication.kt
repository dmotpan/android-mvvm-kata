package com.dmotpan.kata_mvvm

import android.app.Application
import timber.log.Timber

class KataMvvmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
