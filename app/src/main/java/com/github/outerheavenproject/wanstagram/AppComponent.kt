package com.github.outerheavenproject.wanstagram

import com.github.outerheavenproject.wanstagram.ui.ActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        DataModule::class,
        OkHttpClientModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    /*
    AndroidInjector<T> interface defines a method called inject().
    AndroidInjector.Factory<T> defines a method called create().
     */
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>

//    @Component.Factory
//    interface Factory {
//        //Not Need to pass arguments because DataModule has public constructor without arguments
//        fun create(): AppComponent
//    }

    //Annotated members with @Inject in these arguments(dogFragment and shibaFragment) are Injected to them.
//    fun inject(dogFragment: DogFragment): DogFragment
//    fun inject(shibaFragment: ShibaFragment): ShibaFragment

    //convert to inject by SubComponent
//    fun mainActivitySubComponentFactory(): MainActivitySubComponent.Factory

}