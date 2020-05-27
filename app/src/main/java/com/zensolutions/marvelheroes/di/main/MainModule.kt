package com.zensolutions.marvelheroes.di.main

import androidx.lifecycle.ViewModel
import com.zensolutions.marvelheroes.data.network.MarvelRetrofitService.getMarvelHeroFetchApi
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.impl.MarvelHeroFetchImpl
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.di.ViewModelKey
import com.zensolutions.marvelheroes.ui.homeScreen.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
internal object MainModule {

    @JvmStatic
    @MainScope
    @Provides
    fun provideMarvelApiService(): MarvelApi {
        return getMarvelHeroFetchApi()
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideMarvelHeroRepository(
        service: MarvelApi,
        ioDispatcher: CoroutineDispatcher
    ): MarvelHeroFetchRepository {
        return MarvelHeroFetchRepository.getMarvelHeroApi(service, ioDispatcher)
    }


}
