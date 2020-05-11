package dev.rinav

import android.app.Application
import dev.rinav.room_sample.data.UserDatabase

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */

class App : Application() {

    val database by lazy { UserDatabase(applicationContext) }

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}