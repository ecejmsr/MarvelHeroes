package com.zensolutions.marvelheroes.di

import android.app.Application
import androidx.room.Room
import com.zensolutions.marvelheroes.data.persistence.AppDatabase
import com.zensolutions.marvelheroes.di.main.MainScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object MarvelHeroesAppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}
