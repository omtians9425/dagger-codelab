package com.github.outerheavenproject.wanstagram

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        //Not Need to pass arguments because DataModule has public constructor without arguments
        fun create(): AppComponent
    }
}