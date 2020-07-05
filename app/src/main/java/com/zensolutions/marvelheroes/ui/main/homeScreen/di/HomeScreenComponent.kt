package com.zensolutions.marvelheroes.ui.main.homeScreen.di

import com.zensolutions.marvelheroes.ui.main.heroOverview.di.HeroOverviewComponent
import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenFragment
import dagger.Subcomponent

@HomeScreenScope
@Subcomponent(modules = [HomeScreenViewModelModule::class])
interface HomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): HomeScreenComponent
    }

    fun inject(fragment: HomeScreenFragment)

    fun heroOverviewComponent(): HeroOverviewComponent

}
