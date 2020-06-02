package com.zensolutions.marvelheroes.ui.main.homeScreen.di

import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeScreenViewModelModule::class])
interface HomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): HomeScreenComponent
    }

    fun inject(fragment: HomeScreenFragment)
}
