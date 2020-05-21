package com.zensolutions.marvelheroes.injection.main

import com.zensolutions.marvelheroes.ui.main.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}
