package com.zensolutions.marvelheroes.di.main

import com.zensolutions.marvelheroes.ui.homeScreen.HomeScreenFragment
import com.zensolutions.marvelheroes.ui.homeScreen.di.HomeScreenComponent
import com.zensolutions.marvelheroes.ui.homeScreen.di.HomeScreenViewModelModule
import com.zensolutions.marvelheroes.ui.main.MainActivity
import dagger.Component
import dagger.Module
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainSubcomponentsModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

    fun homeScreenComponent(): HomeScreenComponent
}

@Module(
    subcomponents = [
    HomeScreenComponent::class
    ]
)

object MainSubcomponentsModule
