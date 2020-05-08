package com.zensolutions.marvelheroes.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDateTime
import java.util.*

class NetworkModule {

    fun retrofitProvider(): Retrofit {

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(
            Date::class.java, Rfc3339DateJsonAdapter().nullSafe()
        ).build()

        return Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

}
