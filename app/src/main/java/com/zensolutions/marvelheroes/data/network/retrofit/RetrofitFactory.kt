package com.zensolutions.marvelheroes.data.network.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object RetrofitFactory {

    fun <T> retrofitProvider(
        serviceClass: Class<T>,
        baseUrl: String
    ): T {
        //TODO Jose we can optimize okHttp3 here or add custom timeout directly on retrofit
        //TODO Jose we might also want to add some logging information if something fails.

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(
            Date::class.java, Rfc3339DateJsonAdapter().nullSafe()
        ).build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(serviceClass)
    }
}
