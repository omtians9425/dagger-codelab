package com.github.outerheavenproject.wanstagram.ui

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentManager
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragmentModule
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionBottomSheetDialogFragmentBindModule
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionBottomSheetDialogFragmentModule
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionSink
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragmentModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityProvidesModule::class,
            MainActivityBindModule::class,
            DogFragmentModule::class,
            ShibaFragmentModule::class,
            DogActionBottomSheetDialogFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
class MainActivityProvidesModule {
    @Provides
    fun provideFragmentManager(activity: MainActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindContext(context: MainActivity): Context

    @Binds
    fun bindAppNavigator(navigator: AppNavigatorImpl): AppNavigator

    @Binds
    fun bindView(activity: MainActivity): MainContruct.View

    @Binds
    fun bindPresenter(presenter: MainPresenter): MainContruct.Presenter

    @Binds
    fun bindDogActionSink(presenter: MainPresenter): DogActionSink
}
