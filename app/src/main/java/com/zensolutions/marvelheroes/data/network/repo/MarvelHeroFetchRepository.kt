package com.zensolutions.marvelheroes.data.network.repo

import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.impl.MarvelHeroFetchImpl
import com.zensolutions.marvelheroes.di.main.MainScope
import kotlinx.coroutines.CoroutineDispatcher

@MainScope
interface MarvelHeroFetchRepository {

    suspend fun getHeroInformation(characterName: String): ServiceResult<CharacterDataWrapper>

    companion object {

        fun getMarvelHeroApi(
            service: MarvelApi,
            ioDispatcher: CoroutineDispatcher
        ): MarvelHeroFetchRepository {
            return MarvelHeroFetchImpl(service, ioDispatcher)
        }
    }
}
