package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragmentModule
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    /*
    This annotation enables to generate the MainActivitySubcomponent
    that extends an AndroidInjector<MainActivity> and has a Factory that extends an AndroidInjector.Factory<MainActivity> .
     */
    @ContributesAndroidInjector(
        modules = [
            MainActivityBindModule::class,
            DogFragmentModule::class,
            ShibaFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

/*
 MainActivitySubcomponent depends on This Module.
 */
@Module
interface MainActivityBindModule {
    @Binds
    fun bindContext(context: MainActivity): Context

    @Binds
    fun bindAppNavigator(navigator: AppNavigatorImpl): AppNavigator
}