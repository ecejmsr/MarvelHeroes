package com.zensolutions.marvelheroes.ui.main.heroOverview.di

import androidx.lifecycle.ViewModel
import com.zensolutions.marvelheroes.di.ViewModelKey
import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HeroOverViewViewmodelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel::class)
    abstract fun bindViewModel(viewModel: HomeScreenViewModel): ViewModel
}
