package com.zensolutions.marvelheroes.ui.main.homeScreen.di

import androidx.lifecycle.ViewModel
import com.zensolutions.marvelheroes.di.ViewModelKey
import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//Define viewmodels for Home screen here

@Module
abstract class HomeScreenViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenViewModel::class)
    abstract fun bindViewModel(viewModel: HomeScreenViewModel): ViewModel

}
