package com.dc.demo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()


    }
}