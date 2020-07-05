package com.zensolutions.marvelheroes.ui.main.heroOverview.di

import com.zensolutions.marvelheroes.ui.main.heroOverview.HeroOverviewFragment
import com.zensolutions.marvelheroes.ui.main.heroOverview.Temp.TempFragment
import com.zensolutions.marvelheroes.ui.main.homeScreen.di.HomeScreenViewModelModule
import dagger.Subcomponent

@HeroOverviewScope
@Subcomponent(
    modules = [
        HomeScreenViewModelModule::class
    ]
)
interface HeroOverviewComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): HeroOverviewComponent
    }

    fun inject(fragment: HeroOverviewFragment)

    fun inject(fragment: TempFragment)
}
