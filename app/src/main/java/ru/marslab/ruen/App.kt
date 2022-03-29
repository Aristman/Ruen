package ru.marslab.ruen

import android.app.Application

class App : Application() {

    lateinit var setting: SettingsPreferences private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        setting = SettingsPreferences(applicationContext)
    }

    companion object {
        lateinit var instance: App private set
    }
}