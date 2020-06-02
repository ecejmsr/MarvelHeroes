package com.zensolutions.marvelheroes.di

import com.zensolutions.marvelheroes.di.main.MainComponent
import dagger.Module


@Module(
    subcomponents = [
        MainComponent::class
    ]
)
object SubComponentModule
