package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
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

    //Annotated member with @Inject in these arguments(dogFragment and shibaFragment) is Injected to them.
    fun inject(dogFragment: DogFragment): DogFragment
    fun inject(shibaFragment: ShibaFragment): ShibaFragment
}