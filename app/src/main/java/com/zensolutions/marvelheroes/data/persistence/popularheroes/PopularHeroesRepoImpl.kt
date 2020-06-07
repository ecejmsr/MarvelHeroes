package com.zensolutions.marvelheroes.data.persistence.popularheroes

import com.zensolutions.marvelheroes.data.model.heroModel.Character
import com.zensolutions.marvelheroes.di.main.MainScope
import javax.inject.Inject

@MainScope
class PopularHeroesRepoImpl
@Inject
constructor(
    private val popularHeroesDao: PopularHeroesDao
) : PopularHeroesRepository {

    override suspend fun insertPopularHero(character: Character) {
        popularHeroesDao.insert(character)
    }

    override suspend fun getPopularHero(characterString: String): Character? {
        return popularHeroesDao.findByName(characterString)
    }

}
