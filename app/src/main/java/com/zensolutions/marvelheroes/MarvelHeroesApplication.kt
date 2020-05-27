package com.zensolutions.marvelheroes

import android.app.Application
import com.zensolutions.marvelheroes.di.DaggerMarvelHeroesAppComponent
import com.zensolutions.marvelheroes.di.MarvelHeroesAppComponent
import com.zensolutions.marvelheroes.di.main.MainComponent

class MarvelHeroesApplication : Application() {

    lateinit var marvelHeroesAppComponent: MarvelHeroesAppComponent

    private var mainComponent: MainComponent? = null

    override fun onCreate() {
        super.onCreate()
        initMarvelAppComponent()
    }

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = marvelHeroesAppComponent.mainComponent().create()
        }
        return mainComponent as MainComponent
    }

    fun releaseMainComponent() {
        mainComponent = null
    }

    private fun initMarvelAppComponent() {
        marvelHeroesAppComponent = DaggerMarvelHeroesAppComponent.builder()
            .application(this)
            .build()
    }

}
