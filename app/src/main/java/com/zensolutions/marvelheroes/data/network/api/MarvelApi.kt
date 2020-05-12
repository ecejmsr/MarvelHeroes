package com.zensolutions.marvelheroes.data.network.api

import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("v1/public/characters")
    suspend fun getHero(
        @Query("ts") ts: String,
        @Query("name") heroName: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ) : Response<CharacterDataWrapper>
}
