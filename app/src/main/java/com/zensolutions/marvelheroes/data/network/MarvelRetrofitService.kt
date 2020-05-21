package com.zensolutions.marvelheroes.data.network

import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.retrofit.RetrofitFactory

internal object MarvelRetrofitService {

    fun getMarvelHeroFetchApi(): MarvelApi =
        RetrofitFactory.retrofitProvider(MarvelApi::class.java, "http://gateway.marvel.com")
}
