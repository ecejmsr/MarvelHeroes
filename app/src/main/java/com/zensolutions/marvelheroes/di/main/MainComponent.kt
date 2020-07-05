package com.zensolutions.marvelheroes.di.main

import com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes.di.PopularHeroesComponent
import com.zensolutions.marvelheroes.ui.main.homeScreen.di.HomeScreenComponent
import com.zensolutions.marvelheroes.ui.main.MainActivity
import com.zensolutions.marvelheroes.ui.main.heroOverview.HeroOverviewFragment
import com.zensolutions.marvelheroes.ui.main.heroOverview.Temp.TempFragment
import com.zensolutions.marvelheroes.ui.main.heroOverview.di.HeroOverviewComponent
import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenFragment
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

    @MainScope
    fun inject(mainActivity: MainActivity)

    fun inject(fragment: HomeScreenFragment)

    fun inject(fragment: HeroOverviewFragment)

    @MainScope
    fun inject(fragment: TempFragment)

    @MainScope
    fun homeScreenComponent(): HomeScreenComponent

    @MainScope
    fun popularHeroesComponent(): PopularHeroesComponent

}

@Module(
    subcomponents = [
    HomeScreenComponent::class,
    PopularHeroesComponent::class
    ]
)

object MainSubcomponentsModule
