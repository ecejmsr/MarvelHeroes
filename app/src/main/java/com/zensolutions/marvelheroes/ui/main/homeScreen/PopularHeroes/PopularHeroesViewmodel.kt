package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.heroModel.Character
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.persistence.popularheroes.PopularHeroesRepository
import com.zensolutions.marvelheroes.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularHeroesViewmodel @Inject constructor(
    private val popularHeroesRepository: PopularHeroesRepository,
    private val marvelHeroRepository: MarvelHeroFetchRepository,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private val _popularHeroesList: MutableLiveData<ArrayList<Character?>> =
        MutableLiveData()
    val popularHeroesList: LiveData<ArrayList<Character?>> = _popularHeroesList

    private val popularHeroList = Constants.POPULARHEROES

    fun populatePopularHeroList() {
        val popularHeroListResponse = arrayListOf<Character?>()

        viewModelScope.launch {
            withContext(ioDispatcher) {
                withContext(Dispatchers.Default) {
                    for (hero in popularHeroList) {
                        when {
                            popularHeroesRepository.getPopularHero(hero) != null -> {
                                popularHeroListResponse.add(
                                    popularHeroesRepository.getPopularHero(
                                        hero
                                    )
                                )
                            }

                            else -> {
                                handleHeroResponse(
                                    marvelHeroRepository.getHeroInformation(hero),
                                    popularHeroListResponse
                                )?.let {
                                    popularHeroesRepository.insertPopularHero(
                                        it
                                    )
                                }
                            }
                        }
                    }
                }
                _popularHeroesList.postValue(popularHeroListResponse)
            }
        }
    }

    private fun handleHeroResponse(
        response: ServiceResult<CharacterDataWrapper>,
        responseHeroArray: ArrayList<Character?>
    ): Character? {
        when (response) {
            is ServiceResult.Success -> {
                if (!response.data.data?.results.isNullOrEmpty()) {
                    responseHeroArray.add(response.data.data?.results?.get(0))
                    return response.data.data?.results?.get(0)
                }
            }

            is ServiceResult.Error -> response.exception
        }
        return null
    }

}
