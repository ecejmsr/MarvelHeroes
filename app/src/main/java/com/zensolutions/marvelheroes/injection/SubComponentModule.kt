package com.zensolutions.marvelheroes.injection

import com.zensolutions.marvelheroes.injection.main.MainComponent
import com.zensolutions.marvelheroes.injection.main.MainModule
import dagger.Module


@Module(
    subcomponents = [
        MainComponent::class
    ]
)
object SubComponentModule
