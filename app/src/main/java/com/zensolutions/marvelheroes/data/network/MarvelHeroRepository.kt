package com.zensolutions.marvelheroes.data.network

import android.content.Context
import com.zensolutions.marvelheroes.data.model.CharacterDataWrapper

internal interface MarvelHeroRepository {

    suspend fun getHeroInformation(): ServiceResult<CharacterDataWrapper>

    companion object {

        fun getMarvelHeroApi(): MarvelHeroRepository{
            return MarvelHeroFetchImpl()
        }
    }
}
