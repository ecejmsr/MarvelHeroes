package com.zensolutions.marvelheroes.data.network.repo

import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.impl.MarvelHeroFetchImpl

internal interface MarvelHeroFetchRepository {

    suspend fun getHeroInformation(): ServiceResult<CharacterDataWrapper>

    companion object {

        fun getMarvelHeroApi(): MarvelHeroFetchRepository {
            return MarvelHeroFetchImpl()
        }
    }
}
