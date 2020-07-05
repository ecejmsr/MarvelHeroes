package com.zensolutions.marvelheroes.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.zensolutions.marvelheroes.di.main.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MarvelHeroesAppModule::class,
        ViewModelBuilderModule::class,
        SubComponentModule::class
    ]
)

interface MarvelHeroesAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MarvelHeroesAppComponent
    }

    //TODO Jose remove this at the end see if it works?
    fun inject(baseActivity: AppCompatActivity)

    fun mainComponent(): MainComponent.Factory
}
