package com.zensolutions.marvelheroes.di.main

import com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes.di.PopularHeroesComponent
import com.zensolutions.marvelheroes.ui.homeScreen.di.HomeScreenComponent
import com.zensolutions.marvelheroes.ui.main.MainActivity
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
    HomeScreenComponent::class,
    PopularHeroesComponent::class
    ]
)

object MainSubcomponentsModule
