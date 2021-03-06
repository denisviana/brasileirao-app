package com.deniscosta.brasileirao

import android.app.Application
import com.bumptech.glide.annotation.GlideModule
import com.deniscosta.brasileirao.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Denis Costa on 07/08/20.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            modules(appModules)
        }
    }
}

