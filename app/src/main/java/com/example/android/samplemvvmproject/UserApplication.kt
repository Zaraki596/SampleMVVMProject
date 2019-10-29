package com.example.android.samplemvvmproject

import android.app.Application
import com.example.android.samplemvvmproject.data.db.UserRoomDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class UserApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@UserApplication))

    }

}