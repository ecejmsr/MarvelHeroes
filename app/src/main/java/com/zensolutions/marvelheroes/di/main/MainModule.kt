package com.zensolutions.marvelheroes.di.main

import com.zensolutions.marvelheroes.data.network.MarvelRetrofitService.getMarvelHeroFetchApi
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

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
