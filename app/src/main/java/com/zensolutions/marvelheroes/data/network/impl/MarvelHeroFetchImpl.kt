package com.zensolutions.marvelheroes.data.network.impl

import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.network.retrofit.MarvelTSProvider
import com.zensolutions.marvelheroes.data.network.retrofit.RetrofitCallHandler
import com.zensolutions.marvelheroes.di.main.MainScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


@MainScope
class MarvelHeroFetchImpl
@Inject
constructor(
    private val service: MarvelApi,
    private val ioDispatcher: CoroutineDispatcher
) : MarvelHeroFetchRepository {
    override suspend fun getHeroInformation(characterName: String): ServiceResult<CharacterDataWrapper> {

        return withContext(ioDispatcher) {
            RetrofitCallHandler.processCall {
                //TODO JOSE: We need to make a ts and hasher. Preferably with inline
                service.getHero(
                    MarvelTSProvider.setTS(),
                    characterName,
                    "406402f980734048e838275c3ee9aabb",
                    MarvelTSProvider.setPin()
                )
            }
        }
    }
}
