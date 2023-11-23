package br.com.fundatec

import android.app.Application
import android.content.Context
import br.com.fundatec.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        private lateinit var instance: App
        val context: Context
            get() = instance
    }

    init {
        instance = this
        startKoin {
            androidLogger()
            androidContext(instance)
            modules(
                listOf(loginModule)
            )
        }
    }
}