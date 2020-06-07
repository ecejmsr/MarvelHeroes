package com.zensolutions.marvelheroes.data.persistence.popularheroes

import com.zensolutions.marvelheroes.data.model.heroModel.Character
import com.zensolutions.marvelheroes.di.main.MainScope

@MainScope
interface PopularHeroesRepository {

    /*
    Insert Popular Hero response to the DB
     */
    suspend fun insertPopularHero(character: Character)

    /*
    Used to check if there is a character hero in db
     */
    suspend fun getPopularHero(characterString: String): Character?

    companion object {
        fun getPopularHeroesRepository(
            popularHeroesDao: PopularHeroesDao
        ): PopularHeroesRepository {
            return PopularHeroesRepoImpl(popularHeroesDao)
        }
    }
}
