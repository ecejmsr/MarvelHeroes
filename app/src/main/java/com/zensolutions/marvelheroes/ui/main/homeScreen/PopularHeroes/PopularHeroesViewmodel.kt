package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.heroModel.Character
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.persistence.PopularHeroesDao
import com.zensolutions.marvelheroes.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularHeroesViewmodel @Inject constructor(
    private val popularHeroesDao: PopularHeroesDao,
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
        var tempCounter = 0
        viewModelScope.launch {
            withContext(ioDispatcher) {
                withContext(Dispatchers.Default) {
                    for (hero in popularHeroList) {
                        handleHeroResponse(
                            marvelHeroRepository.getHeroInformation(hero),
                            tempList
                        )

                        if(tempCounter == 0 && tempList.isNotEmpty()){
                            tempList[0]?.data?.results?.get(0)?.let { insertCharacterToDatabase(it) }
                            tempCounter++
                        }
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

    private suspend fun insertCharacterToDatabase(characterResponse: Character){
        popularHeroesDao.insert(characterResponse)
    }
}
