package com.zensolutions.marvelheroes.data.network

import com.zensolutions.marvelheroes.data.model.CharacterDataWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create

class MarvelHeroFetchImpl(
    private val service: MarvelApi = NetworkModule().retrofitProvider().create(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarvelHeroRepository {
    override suspend fun getHeroInformation(): ServiceResult<CharacterDataWrapper> {

        return withContext(ioDispatcher) {
            RetrofitCallHandler.processCall {
                //TODO JOSE: We need to make a ts and hasher. Preferably with inline
                service.getHero("1", "Thor", "406402f980734048e838275c3ee9aabb", "db60ad1dd91f9882dede231cb64f0776")
            }
        }
    }
}
