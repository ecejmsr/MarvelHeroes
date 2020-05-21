package com.zensolutions.marvelheroes.injection.main

import com.zensolutions.marvelheroes.data.network.MarvelRetrofitService.getMarvelHeroFetchApi
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import dagger.Module
import dagger.Provides

@Module
internal object MainModule {

    @JvmStatic
    @Provides
    fun provideMarvelApiService(): MarvelApi{
        return getMarvelHeroFetchApi()
    }
}
