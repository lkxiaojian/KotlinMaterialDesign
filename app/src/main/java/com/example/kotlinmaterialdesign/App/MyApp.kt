package com.example.kotlinmaterialdesign.App

import android.app.Application

/**
 *create_time : 20-12-21 上午10:00
 *author: root
 *description： MyApp
 */
class MyApp : Application() {
    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}