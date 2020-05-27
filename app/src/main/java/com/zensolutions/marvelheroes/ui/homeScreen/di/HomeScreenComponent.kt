package com.zensolutions.marvelheroes.ui.homeScreen.di

import com.zensolutions.marvelheroes.di.main.MainScope
import com.zensolutions.marvelheroes.ui.homeScreen.HomeScreenFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeScreenViewModelModule::class])
interface HomeScreenComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): HomeScreenComponent
    }

    fun inject(fragment: HomeScreenFragment)
}
