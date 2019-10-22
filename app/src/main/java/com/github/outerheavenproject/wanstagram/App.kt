package com.github.outerheavenproject.wanstagram

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.create()
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }

    //AndroidInjector resolves dependency about Activity and Fragment
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}