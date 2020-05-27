package com.zensolutions.marvelheroes.di

import com.zensolutions.marvelheroes.di.main.MainComponent
import com.zensolutions.marvelheroes.ui.homeScreen.di.HomeScreenComponent
import dagger.Module


@Module(
    subcomponents = [
        MainComponent::class
    ]
)
object SubComponentModule
