package com.zensolutions.marvelheroes.di.main

import android.app.Application
import androidx.room.Room
import com.zensolutions.marvelheroes.data.network.MarvelRetrofitService.getMarvelHeroFetchApi
import com.zensolutions.marvelheroes.data.network.api.MarvelApi
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.persistence.AppDatabase
import com.zensolutions.marvelheroes.data.persistence.PopularHeroesDao
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
internal object MainModule {

    @JvmStatic
    @MainScope
    @Provides
    fun provideMarvelApiService(): MarvelApi {
        return getMarvelHeroFetchApi()
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideMarvelHeroRepository(
        service: MarvelApi,
        ioDispatcher: CoroutineDispatcher
    ): MarvelHeroFetchRepository {
        return MarvelHeroFetchRepository.getMarvelHeroApi(service, ioDispatcher)
    }

    @JvmStatic
    @MainScope
    @Provides
    fun providePopularHeroesDao(db: AppDatabase): PopularHeroesDao {
        return db.popularHeroesDao()
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}
