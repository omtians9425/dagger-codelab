package com.github.outerheavenproject.wanstagram.ui.dog

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogFragmentModule {
    @ContributesAndroidInjector(modules = [DogFragmentBindModule::class])
    fun contributeDogFragment(): DogFragment
}

@Module
interface DogFragmentBindModule {
    @Binds
    fun bindPresenter(presenter: DogPresenter): DogContract.Presenter
}
