package com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes.di

import com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes.PopularHeroesListFragment
import dagger.Subcomponent

@Subcomponent
interface PopularHeroesComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create() : PopularHeroesComponent
    }

    fun inject(fragment: PopularHeroesListFragment)
}
