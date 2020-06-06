package com.zensolutions.marvelheroes.di.main

import com.zensolutions.marvelheroes.data.persistence.PopularHeroesDao
import com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes.di.PopularHeroesComponent
import com.zensolutions.marvelheroes.ui.main.homeScreen.di.HomeScreenComponent
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

    fun popularHeroesComponent(): PopularHeroesComponent
}

@Module(
    subcomponents = [
    HomeScreenComponent::class,
    PopularHeroesComponent::class
    ]
)

object MainSubcomponentsModule
