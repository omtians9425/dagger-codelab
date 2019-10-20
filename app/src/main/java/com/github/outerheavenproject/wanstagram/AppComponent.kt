package com.github.outerheavenproject.wanstagram

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}