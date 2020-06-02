package com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularHeroesViewmodel @Inject constructor(
    private val marvelHeroRepository: MarvelHeroFetchRepository,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private val _popularHeroesList: MutableLiveData<ArrayList<CharacterDataWrapper?>> =
        MutableLiveData()
    val popularHeroesList: LiveData<ArrayList<CharacterDataWrapper?>> = _popularHeroesList


    private val popularHeroList = Constants.POPULARHEROES


    fun populatePopularHeroList() {
        val tempList = arrayListOf<CharacterDataWrapper?>()
        viewModelScope.launch {
            withContext(ioDispatcher) {
                withContext(Dispatchers.Default) {
                    for (hero in popularHeroList) {
                        handleHeroResponse(
                            marvelHeroRepository.getHeroInformation(hero),
                            tempList
                        )
                    }
                }
                _popularHeroesList.postValue(tempList)
            }
        }
    }

    private fun handleHeroResponse(
        response: ServiceResult<CharacterDataWrapper>,
        responseHeroArray: ArrayList<CharacterDataWrapper?>
    ) {
        when (response) {
            is ServiceResult.Success -> {
                if (!response.data.data?.results.isNullOrEmpty()) {
                    responseHeroArray.add(response.data)
                }
            }

            is ServiceResult.Error -> response.exception
        }
    }
}
