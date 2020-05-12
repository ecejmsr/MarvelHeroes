package com.zensolutions.marvelheroes.data.network.impl

import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.MarvelRetrofitService
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.network.retrofit.MarvelTSProvider
import com.zensolutions.marvelheroes.data.network.retrofit.RetrofitCallHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelHeroFetchImpl(
    private val service: MarvelApi = MarvelRetrofitService().getMarvelHeroFetchApi(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelHeroFetchRepository {
    override suspend fun getHeroInformation(): ServiceResult<CharacterDataWrapper> {

        return withContext(ioDispatcher) {
            RetrofitCallHandler.processCall {
                //TODO JOSE: We need to make a ts and hasher. Preferably with inline
                service.getHero(
                    MarvelTSProvider.setTS(),
                    "Thor",
                    "406402f980734048e838275c3ee9aabb",
                    MarvelTSProvider.setPin()
                )
            }
        }
    }
}
