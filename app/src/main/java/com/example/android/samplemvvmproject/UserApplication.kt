package com.example.android.samplemvvmproject

import android.app.Application
import com.example.android.samplemvvmproject.data.network.ApiService
import com.example.android.samplemvvmproject.data.network.ConnectivityInterceptor
import com.example.android.samplemvvmproject.data.network.ConnectivityInterceptorImpl
import com.example.android.samplemvvmproject.ui.viewmodel.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class UserApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@UserApplication))

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind() from singleton { UserViewModelFactory(instance()) }
    }

}