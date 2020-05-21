package com.zensolutions.marvelheroes.injection

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.zensolutions.marvelheroes.injection.main.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
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

    fun inject(baseActivity: AppCompatActivity)

    fun mainComponent(): MainComponent.Factory
}
