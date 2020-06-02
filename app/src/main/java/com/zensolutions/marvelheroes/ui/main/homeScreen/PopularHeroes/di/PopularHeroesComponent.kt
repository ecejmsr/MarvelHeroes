package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes.di

import com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes.PopularHeroesListFragment
import dagger.Subcomponent

@Subcomponent
interface PopularHeroesComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create() : PopularHeroesComponent
    }

    fun inject(fragment: PopularHeroesListFragment)
}
