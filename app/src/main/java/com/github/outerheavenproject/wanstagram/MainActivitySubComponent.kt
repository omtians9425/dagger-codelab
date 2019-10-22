package com.github.outerheavenproject.wanstagram

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.AppNavigator
import com.github.outerheavenproject.wanstagram.ui.MainActivity
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivitySubComponent
    }

    fun inject(activity: MainActivity): MainActivity
    fun inject(dogFragment: DogFragment): DogFragment
    fun inject(shibaFragment: ShibaFragment): ShibaFragment
}

@Module
interface MainActivityModule {
    @Binds
    fun bindAppNavigator(appNavigator: AppNavigator): AppNavigator
}