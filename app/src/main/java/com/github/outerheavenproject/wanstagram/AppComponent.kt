package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        OkHttpClientModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        //Not Need to pass arguments because DataModule has public constructor without arguments
        fun create(): AppComponent
    }

    //Annotated members with @Inject in these arguments(dogFragment and shibaFragment) are Injected to them.
//    fun inject(dogFragment: DogFragment): DogFragment
//    fun inject(shibaFragment: ShibaFragment): ShibaFragment

    //convert to inject by SubComponent
    fun mainActivtySubcompoentFactory(): MainActivitySubComponent.Factory

}